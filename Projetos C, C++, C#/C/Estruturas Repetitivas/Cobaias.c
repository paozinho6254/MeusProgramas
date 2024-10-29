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

    float porcb, porcr, porcf;
    int N, i, slavs, rat, buny, frog, X;
    char type;

    rat = 0;
    buny = 0;
    frog = 0;
    slavs = 0;

    printf("Digite o numero de casos: ");
    scanf("%i", &N);

    for(i = 0; i < N; i++){
        printf("Cobaias utilizados = ");
        scanf("%i", &X);
        slavs = slavs + X;
        printf("Tipo de cobaia (R/B/F)= ");
        limpar_entrada();
        scanf("%c", &type);

        if(type == 'R'){
            rat = rat + X;
        }
        else if(type == 'C'){
            buny = buny + X;
        }
        else if (type == 'S'){
            frog = frog + X;
        }
    }
    printf("\nRelatorio final :\n");
    printf("Total = %i de cobaias\n", slavs);
    printf("Total de ratos = %i\n", rat);
    printf("Total de coelhos = %i\n", buny);
    printf("Total de sapos = %i\n", frog);

    porcr = rat;
    porcb = buny;
    porcf = frog;

    porcr = (porcr / slavs) * 100;
    porcb = (porcb / slavs) * 100;
    porcf = (porcf / slavs) * 100;

    printf("Percentual de coelhos = %.2f\n", porcb);
    printf("Percentual de ratos = %.2f\n", porcr);
    printf("Percentual de sapos = %.2f\n", porcf);

    return 0;
}

