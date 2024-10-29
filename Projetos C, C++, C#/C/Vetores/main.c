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
    int N, M, i, j;

    printf("Qual a quantidade de linhas da matriz? ");
    scanf("%i", &N);
    printf("Qual a quantidade de colunas na matriz? ");
    scanf("%i", &M);

    double mat[N][M], somador;

    for (i = 0; i < N; i++){
        printf("Digite os elementos da %ia. linha: \n", i + 1);
        for (j = 0; j < M; j++){
            scanf("%lf", &mat[i][j]);
        }
    }

    double soma[N];

    for(i = 0; i < N; i++){
        somador = 0;

        for(j = 0; j < M; j++){
            somador = somador + mat[i][j];
        }
        soma[i] = somador;
    }

    printf("VETOR GERADO:\n");

    for(i = 0; i < N; i++){
        printf("%.1lf\n", soma[i]);
        }

    return 0;
}
