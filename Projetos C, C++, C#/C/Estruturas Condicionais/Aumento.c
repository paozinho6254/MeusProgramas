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
    int hi, hf;

    printf("Hora inicial: ");
    scanf("%i", &hi);
    printf("Hora final: ");
    scanf("%i", &hf);

    if(hi < hf){
        printf("O JOGO DUROU %i HORA(S)", hf - hi);
    }
    else{
        printf("O JOGO DUROU %i HORA(S)", 24 + (hf - hi));
    }
}
