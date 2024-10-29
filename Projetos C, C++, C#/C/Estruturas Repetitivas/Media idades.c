#include <stdio.h>
#include <string.h>

void ler_texto(char *buffer, int length) {
 fgets(buffer, length, stdin);
 strtok(buffer, "\n");
}

void limpar_entrada() {
 char c;
 while ((c = getchar()) != '\n' && c != EOF) {}
}

int main() {

    double media;
    int X, count;

    count = 0;
    media = 0;

    printf("Digite as idades:\n");

    do
    {
        scanf("%i", &X);
        if (X > 0)
        {
            count = count + 1;
            media = media + X;
        }
    }
    while (X > 0);

    media = media / count;

    if (count == 0)
    {
        printf("IMPOSSIVEL CALCULAR");
    }
    else
    {
        printf("MEDIA = %.2lf", media);
    }
    return 0;
}
