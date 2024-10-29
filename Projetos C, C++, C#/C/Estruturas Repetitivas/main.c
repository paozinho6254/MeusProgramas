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

    int N, i, X, in, out;

    printf("Digite quantos numeros voce ira digitar: ");
    scanf("%i", &N);

    in = 0;
    out = 0;
    for(i = 0; i < N; i++){
        printf("Digite um numero: ");
        scanf("%i", &X);
        if(X <= 20 && X >= 10){
            in = in + 1;
        }
        else{
            out = out + 1;
        }
    }
    printf("Dentro: %i", in);
    printf("\nFora: %i", out);

}

