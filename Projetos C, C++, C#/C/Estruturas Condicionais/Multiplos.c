#include <stdio.h>
#include <stdlib.h>

void limpar_entrada()
{
    char c;
    while ((c = getchar()) != '\n' && c != EOF) {}
}

void ler_texto(char *buffer, int length)
{
    fgets(buffer, length, stdin);
    strtok(buffer, "\n");
}

int main()
{
    int porc;
    double olmone, neomone, tip;

    printf("Digite o salario da pessoa: ");
    scanf("%lf", &olmone);

    if(olmone <= 1000){
        neomone = olmone * 1.20;
        tip = olmone * 0.20;
        porc = 20;
    }
    else if(olmone > 1000 && olmone <= 3000){
        neomone = olmone * 1.15;
        tip = olmone * 0.15;
        porc = 15;
    }
    else if(olmone > 3000 && olmone <= 8000){
        neomone = olmone * 1.10;
        tip = olmone * 0.10;
        porc = 10;
    }
    else {
        neomone = olmone * 1.05;
        tip = olmone * 0.05;
        porc = 5;
    }

    printf("Novo salario = %.2lf", neomone);
    printf("\nAumento = %.2lf", tip);
    printf("\nPorcentagem = %i", porc);

}
