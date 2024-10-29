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

    int N, i;
    float X, count, fina;

    printf("Digite o numero de casos: ");
    scanf("%i", &N);

    for(i = 0; i < N; i++){
        count = 0;
        printf("Digite 3 numeros:\n");

        scanf("%f", &X, "\n");
        count = count + X * 2;

        scanf("%f", &X, "\n");
        count = count + X * 3;

        scanf("%f", &X, "\n");
        count = count + X * 5;

        fina = count / 10;

        printf("\nMedia P: %.1f\n", fina);
    }

}

