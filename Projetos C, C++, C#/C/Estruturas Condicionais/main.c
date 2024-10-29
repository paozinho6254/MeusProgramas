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
    int min;
    double value;

    min = 0;
    printf("Digite a quantidade de minutos: ");
    scanf("%i", &min);

    if (min > 100){
        value = ((min - 100) * 2) + 50;
        printf("\nValor a pagar: R$%.2f", value);
    }
        else{
            printf("Valor a pagar: R$50.00");
        }
}
