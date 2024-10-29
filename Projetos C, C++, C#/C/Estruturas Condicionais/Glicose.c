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
    double dist, bigg;

    bigg = 0;

    printf("Digite as 3 distancias:\n");
    scanf("%lf", &dist);

    if(dist > bigg){
        bigg = dist;
    }
    scanf("%lf", &dist);
    if(dist > bigg){
        bigg = dist;
    }
    scanf("%lf", &dist);
    if(dist > bigg){
        bigg = dist;
    }

    printf("Maior distancia = %.2lf", bigg);
}
