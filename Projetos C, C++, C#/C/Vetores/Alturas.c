#include <stdio.h>
#include <stdlib.h>

void limpar_entrada() {
 char c;
 while ((c = getchar()) != '\n' && c != EOF) {}
}

void ler_texto(char *buffer, int length) {
 fgets(buffer, length, stdin);
 strtok(buffer, "\n");
}

int main()
{
    int N, i;
    double nmenores, percentualMenores, mediaa;


    printf("Quantas pessoas serao digitadas? ");
    scanf("%i", &N);

    char nome[50][N];
    int idade[N];
    double alt[N];

    for (i = 0; i < N; i++)
    {
        printf("Dados da %ia pessoa:\n", i + 1);


        printf("Nome: ");
        limpar_entrada();
        ler_texto(nome[i], 50);
        printf("Idade: ");
        scanf("%i", &idade[i]);
        printf("Altura: ");
        scanf("%lf", &alt[i]);
        printf("\n");
        limpar_entrada();
    }

    nmenores = 0;

    for (i = 0; i < N; i++)
    {
        if (idade[i] < 16)
        {
            nmenores++;
        }
    }

    mediaa = 0;

    for (i = 0; i < N; i++)
    {
        mediaa = mediaa + alt[i];
    }

    mediaa = mediaa / N;

    percentualMenores = ((double)nmenores / N) * 100.0;

    printf("\nAltura media = %.2lf\n", mediaa);
    printf("Pessoas com menos de 16 anos: %.1lf%%\n", percentualMenores);

    for(i = 0; i < N; i++)
    {
        if (idade[i] < 16)
        {
            printf("%s\n", nome[i]);
        }
    }



    return 0;
}
