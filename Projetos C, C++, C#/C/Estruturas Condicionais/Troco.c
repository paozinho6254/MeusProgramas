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
    double glic;

    printf("Digite a medida da glicose: ");
    scanf("%lf", &glic);

    if(glic <= 100){
        printf("Classificacao: Normal");
    }
    else if(glic > 100 && glic <= 140){
        printf("Classificacao: Elevado");
    }
    else{
        printf("Classificacao: Diabetes");
    }
}
