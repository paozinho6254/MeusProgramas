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
    int X, Y, troca;

    printf("Digite dois números inteiros\n");
    scanf("%i", &X);
    scanf("%i", &Y);

    if(X > Y){
        troca = Y;
        Y = X;
        X = troca;
    }

    if(Y % X == 0){
        printf("Sao multiplos");
    }
    else{
        printf("Nao sao multiplos");
    }
}
