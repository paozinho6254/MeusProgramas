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

    int X, i;

    printf("Digite o valor de X: ");
    scanf("%i", &X);

    for(i = 0; i < X; i++){
        if(i % 2 != 0){
            printf("%i\n", i);
        }
    }
    return 0;
}

