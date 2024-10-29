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
    double N1, N2, NF;

    printf("Digite a primeira nota: ");
    scanf("%lf", &N1);

    printf("Digite a segunda nota: ");
    scanf("%lf", &N2);

    NF = N1 + N2;

    if (NF < 60.0) {
        printf("REPROVADO");
    }
    else {
        printf("Nota final: %.1lf", NF);
    }

    return 0;
}
