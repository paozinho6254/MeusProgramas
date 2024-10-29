#include <stdio.h>
#include <stdlib.h>

void limpar_entrada() {
 char c;
 while ((c = getchar()) != '\n' && c != EOF) {}
}

void ler_texto(char *buffer, int length) {
 fgets(buffer, length, stdin);
 strtok(buffer, "\n");
}

int main()
{

    int M, N, i, j;


    printf("Qual a ordem da matriz? ");
    scanf("%i", &N);
    M = N;

    int mat[N][M];

    for (i = 0; i < N; i++) {
        for (j = 0; j < M; j++){
            printf("Elemento [%i,%i]: ", i ,j);
            scanf("%i", &mat[i][j]);
        }
    }

    int diag[N];

    for (i = 0; i < N; i++) {
        for (j = 0; j < M; j++){
            for (i = 0; i < N; i++){
                if (i == j) {
                    diag[i] = mat[i][j];
                }
            }
        }
    }

    printf("Diagonal principal:\n");

    for (i = 0; i < N; i++){
            printf(" %i ", diag[i]);
    }

    int neg;
    neg = 0;

    for (i = 0; i < N; i++){
        for (j = 0; j < M; j++){
            if (mat[i][j] < 0){
                neg = neg + 1;
            }
        }
    }

    printf("\nQUANTIDADE DE NEGATIVOS= %i", neg);
    return 0;
}
