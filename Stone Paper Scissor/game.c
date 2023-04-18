#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>


int randomValue(){
     srand(time(NULL));
     return rand()%2;
}
int main(){
    
    char user_name[100];
    printf("\n\nEnter your name\n");
    scanf("%s",&user_name);
    printf("\n\nWelcome to ROCK PAPER SCISSORS %s\n",user_name);
    

    int temp,score_c,score_human;
    score_c=0;
    score_human=0;
    char move[100];
    for(int i=0 ; i<3 ; i++){
    printf("\nEnter rock paper or scissor\n");
    scanf("%s",move);
    if(strcmp(move, "rock") == 0){
      temp=0;
    }
    if(strcmp(move, "paper") == 0){
        temp=1;
    }
    if(strcmp(move, "scissor") == 0){
        temp=2;
    }
    
    if(randomValue()==0 ){
       
        if(temp==0){
            printf("DRAW\n");
        }
        else if(temp==1){
            printf("YOU WON\n");
            score_human++;
        }
        else{
            printf("YOU LOST\n");
            score_c++;
        }
    }

    else if(randomValue()==1){
        
        if(temp==0){
            printf("YOU LOST\n");
            score_c++;
        }
        else if(temp==1){
            printf("DRAW\n");
        }
        else{
            printf("YOU WIN\n");
            score_human++;
        }
    }

    else{
       
        if(temp==0){
            printf("YOU WIN\n");
            score_human++;
        }
        else if(temp==1){
            printf("YOU LOST\n");
            score_c++;
        }
        else{
            printf("DRAW\n");
        }
    }

    }
    printf("The Final Score Computer Vs Human is %d-%d\n",score_c,score_human);
    if(score_human>score_c){
        printf("Human Won\n");
    }
    else{
        printf("Computer Won\n BETTER LUCK NEXT TIME");
    }
    return 0;
}