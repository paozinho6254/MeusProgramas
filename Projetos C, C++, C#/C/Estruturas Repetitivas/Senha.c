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
    int X, Y;

    printf("\nDigite os valores das coordenadas X e Y:\n");
    scanf("%i", &X);
    scanf("%i", &Y);

    while(X != 0 && Y != 0){

    if(X > 0 && Y > 0){
    printf("QUADRANTE Q1");
    }
    else if(X < 0 && Y > 0){
    printf("QUADRANTE Q2");
    }
    else if(X < 0 && Y < 0){
    printf("QUADRANTE Q3");
    }
    else if(X > 0 && Y < 0){
    printf("QUADRANTE Q4");
    }
    printf("\nDigite os valores das coordenadas X e Y:\n");
    scanf("%i", &X);
    scanf("%i", &Y);
    }
    printf("");
    return 0;
}

