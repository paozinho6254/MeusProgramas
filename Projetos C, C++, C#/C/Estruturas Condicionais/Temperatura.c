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
    int code, qntd;
    double total;

    printf("Codigo do produto comprado: ");
    scanf("%i", &code);

    if(code == 1){
        printf("Quantidade comprada: ");
        scanf("%i", &qntd);
        total = qntd * 5.00;
    }
    else if(code == 2){
        printf("Quantidade comprada: ");
        scanf("%i", &qntd);
        total = qntd * 3.50;
    }
    else if(code == 3){
        printf("Quantidade comprada: ");
        scanf("%i", &qntd);
        total = qntd * 4.80;
    }
    else if(code == 4){
        printf("Quantidade comprada: ");
        scanf("%i", &qntd);
        total = qntd * 8.90;
    }
    else if(code == 5){
        printf("Quantidade comprada: ");
        scanf("%i", &qntd);
        total = qntd * 7.32;
    }
    printf("Valor a pagar: %.2lf", total);
}
