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

    int N, i, X, resu;

    printf("Deseja a tabuada para qual valor? ");
    scanf("%i", &X);

    for(i = 0; i < N; i++){
        resu = N * i;
        printf("%i x %i = ", N, i, resu);
    }

    return 0;
}

