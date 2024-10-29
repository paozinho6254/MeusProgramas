#include <stdio.h>
#include <stdlib.h>

void limpar_entrada()
{
    char c;
    while ((c = getchar()) != '\n' && c != EOF) {}
}

void ler_texto(char *buffer, int length)
{
    fgets(buffer, length, stdin);
    strtok(buffer, "\n");
}

int main()
{
    double X, Y;

    printf("Valor de X: ");
    scanf("%lf", &X);
    printf("Valor de Y: ");
    scanf("%lf", &Y);

    if(X == 0 && Y == 0){
        printf("Origem");
    }
    else if(X == 0){
        printf("Eixo Y");
    }
    else if(Y == 0){
        printf("Eixo X");
    }
    else if(X > 0 && Y > 0){
        printf("Q1");
    }
    else if(X < 0 && Y > 0){
        printf("Q2");
    }
    else if(X < 0 && Y < 0){
        printf("Q3");
    }
    else if(X > 0 && Y < 0){
        printf("Q4");
    }
}
