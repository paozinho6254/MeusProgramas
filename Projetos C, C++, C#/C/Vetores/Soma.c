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

    printf("Quantos numeros voce ira digitar: ");
    scanf("%i", &N);

    double vet[N];

    for (i = 0; i < N; i++) {
        printf("Digite um numero: ");
        scanf("%lf", &vet[i]);
    }

    printf("Numeros negativos:\n");

    for (i = 0; i < N; i++){
            if (vet[i] < 0){
                printf("%.1lf\n", vet[i]);
            }
    }
    return 0;
}

