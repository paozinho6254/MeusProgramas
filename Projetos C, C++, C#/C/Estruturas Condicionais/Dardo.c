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
    char resp;
    double fahk, cels;

    printf("Voce vai digitar a temperatura em qual escala (C/F)? ");
    scanf("%c", &resp);

    if(resp == 'F'){
        printf("Digite a temperatura em Fahrenheit:");
        scanf("%lf", &fahk);
        cels = ((fahk - 32) * 5) / 9;

        printf("Temperatura equivalente em Celsius: %.2lf", cels);
    }
    else if(resp == 'C'){
        printf("Digite a temperatura em Celsius:");
        scanf("%lf", &cels);
        fahk = ((cels * 9)/5) + 32;
        printf("Temperatura equivalente em Fahrenheit: %.2lf", fahk);
    }
}
