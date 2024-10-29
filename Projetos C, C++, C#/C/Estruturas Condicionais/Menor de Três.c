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
    int X, Y, Z, menor;

    printf("Primeiro valor: ");
    scanf("%i", &X);
    menor = X;

    printf("Segundo valor: ");
    scanf("%i", &Y);
    if (Y < menor) {
            menor = Y;
    }

    printf("terceiro valor: ");
    scanf("%i", &Z);
    if (Z < menor) {
            menor = Z;
    }

    printf("Menor: %i", menor);

    return 0;
}
