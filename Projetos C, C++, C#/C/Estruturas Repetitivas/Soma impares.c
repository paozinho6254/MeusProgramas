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

    int X, Y, count, troca, i;

    printf("Digite dois numeros: \n");
    scanf("%i", &X);
    scanf("%i", &Y);

    if (X > Y)
    {
        troca = X;
        X = Y;
        Y = troca;
    };

    count = 0;

    for (i = X + 1; i < Y; i++) {
        if (i % 2 != 0) {
            count = count + i;
        }
    }

    printf("Soma dos impares: %i\n", count);

    return 0;
}

