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

    double X, Y, nota;

    printf("Digite a primeira nota: ");
    scanf("%lf", &X);
    if(X < 0 || X > 10){
    while(X < 0 || X > 10){
        printf("Tente novamente! ");
        printf("\nDigite a primeira nota: ");
        scanf("%lf", &X);
        }
    }

    nota = X + nota;

    printf("\nDigite a segunda nota: ");
    scanf("%lf", &Y);
    if(X < 0 || X > 10){
    while(Y < 0 || Y > 10){
        printf("Tente novamente! ");
        printf("\nDigite a segunda nota: ");
        scanf("%lf", &Y);
        }
    }
    nota = Y + nota;

    printf("Media = %.2lf", nota/2);

    return 0;
}

