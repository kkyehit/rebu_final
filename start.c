#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <string.h>
#include <dirent.h>
#include <signal.h>
#include <sys/wait.h>

#define servercnt 7

const char servername[servercnt][20] = {"eurekaServer","zuulServer","configServer","memberServer","orderServer","delivererServer","reviewServer"}; 
pid_t pid[8];

void sig_chld(int signal){
    pid_t pid_closed;
    char pathname[256], workDirectory[256];

    memset(workDirectory, 0, sizeof(workDirectory));
    getcwd(workDirectory, sizeof(workDirectory));

    pid_closed = waitpid(-1, NULL, WNOHANG);
    if (pid_closed <= 0)
        return;
    for(int i = 0; i < servercnt; i++){
        if(pid_closed == pid[i]){
            pid[i] = fork();
            if(pid[i] == 0){
                
                memset(pathname, 0, sizeof(pathname));
                strcpy(pathname, workDirectory);
                strcat(pathname, "/");
                strcat(pathname, servername[i]);
                printf("execute : %s\n",pathname);
                chdir(pathname);
                execl("/usr/bin/xterm","xterm","-e","mvn spring-boot:run",NULL);
                chdir(workDirectory);
            }
        }
    }
    sleep(1);
}

int main(void){
    char pathname[256], workDirectory[256];
    int forkPid = 0;

    memset(workDirectory, 0, sizeof(workDirectory));
    getcwd(workDirectory, sizeof(workDirectory));

    memset(pid, 0, sizeof(pid));
    system("ifconfig | grep inet");

    struct sigaction act;
    act.sa_handler = sig_chld;
    sigemptyset(&act.sa_mask);
    act.sa_flags = 0;
    sigaction(SIGCHLD, &act, 0);

    for(int i = 0; i < servercnt; i++){
        memset(pathname, 0, sizeof(pathname));
        strcpy(pathname, workDirectory);
        strcat(pathname, "/");
        strcat(pathname, servername[i]);
        if(chdir(pathname) == -1){
            printf("chdir error\n");
            continue;
        }
        printf("execute : %s\n",pathname);
        
        forkPid = fork();
        if(forkPid == 0){
            execl("/usr/bin/xterm","xterm","-e","mvn spring-boot:run",NULL);
        }else if(forkPid > -1){
            pid[i] = forkPid;
        }else{
            printf("errror for %s\n",servername[i]);
        }

        chdir(workDirectory);
        sleep(10);
    }
    
    
    int isTerminal = 0;
    while(!isTerminal){
        sleep(1000);
        isTerminal = 1;
        for(int i = 0; i < 8; i++)
            if(pid[i] != 0){
                isTerminal = 0;
                continue;
            }
    }
}