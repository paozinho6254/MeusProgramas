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
    float X, Y, count;

    printf("Digite o numero de casos: ");
    scanf("%i", &N);

    for(i = 0; i < N; i++){
        printf("Digite o numerador: ");
        scanf("%f", &X);
        printf("Digite o divisor: ");
        scanf("%f", &Y);

        if(X == 0 || Y == 0){
            printf("Impossivel realizar a conta!\n");
        }

        else{
            count = X / Y;
            printf("Conta = %.2f\n", count);
        }
    }
}

