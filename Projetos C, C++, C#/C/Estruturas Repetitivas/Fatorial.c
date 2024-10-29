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

    int N, i, fator;

    printf("Insira o Numero para fatoriar: ");
    scanf("%i", &N);
    fator = N;
    for(i = 1; i < N; i++){
        fator = fator * i;
    }
    if(N == 0){
        fator = 0;
        printf("Fatorial = 1");
    }
    else{
        printf("Fatorial = %i", fator);
    }

}

