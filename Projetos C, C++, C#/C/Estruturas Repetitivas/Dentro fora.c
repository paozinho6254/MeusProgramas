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

    int N, i, X;

    printf("Quantos numeros voce ira digitar: ");
    scanf("%i", &N);

    for(i = 0; i < N; i++){
        printf("\nDigite um numero: ");
        scanf("%i", &X);

        if(X == 0){
            printf("Nulo");
        }

        else if(X % 2 == 0){
            printf("Par\n");
        }
        else {
            printf("Impar\n");
        }
        if(X > 0){
            printf("Positivo\n");
        }
        else if(X < 0){
            printf("Negativo\n");
        }

    }

}

