#include <stdio.h>
#include <stdlib.h>

int main()
{
    double larg, comp, area, valor, metro;

    printf("Digite a largura do terreno: ");
    scanf("%lf", &larg);
    printf("Digite o comprimento do terreno: ");
    scanf("%lf", &comp);
    printf("Digite o valor do metro quadrado: ");
    scanf("%lf", &metro);
    area = larg * comp;
    valor = area * metro;
    printf("\n");
    printf("Área do terrenon = %.2lf", area);
    printf("\nValor do terreno = %.2lf", valor);

    return 0;
}
