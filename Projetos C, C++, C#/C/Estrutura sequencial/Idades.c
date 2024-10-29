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
    char pers1[50], pers2[50];
    double age1, age2, agem;

    printf("Dados da primeira pessoa:\n");
    printf("Nome: ");
    ler_texto(pers1, 50);
    printf("Idade: ");
    scanf("%lf", &age1);
    printf("Dados da segunda pessoa:\n");
    limpar_entrada();
    printf("Nome: ");
    ler_texto(pers2, 50);
    printf("Idade: ");
    scanf("%lf", &age2);

    agem = ((age1 + age2) /2);
    printf("\n");
    printf("A idade media de %s e %s e de %.2lf anos", pers1, pers2, agem);


    return 0;
}
