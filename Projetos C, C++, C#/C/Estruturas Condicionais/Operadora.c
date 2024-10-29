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

    double prdt, mone, troco, total, qntd;

    printf("Preço unitario do produto: ");
    scanf("%lf", &prdt);
    printf("Quantidade comprada: ");
    scanf("%lf", &qntd);
    printf("Dinheiro recebido: ");
    scanf("%lf", &mone);

    total = prdt * qntd;



    if(mone < total){
        troco = total - mone;
        printf("DINHEIRO INSUFICIENTE, FALTAM R$ %.2lf", troco);
    }
        else{
            troco = mone - total;
            printf("Troco: R$ %.2lf", troco);
        }
}
