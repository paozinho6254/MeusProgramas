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

    int resp, gas, die, Alc;
    gas = 0;
    die = 0;
    Alc = 0;


    while(resp != 4){
    printf("Informe um codigo (1, 2, 3) ou 4 para parar: ");
    scanf("%i", &resp);
    if(resp == 1){
        gas = gas + 1;
    }
    else if(resp == 2){
        die = die + 1;
    }
    else if(resp == 3){
        Alc = Alc + 1;
    }

    }

    printf("Gasolina = %i", gas);
    printf("\nDiesel = %i", die);
    printf("\nAlc = %i", Alc);

    return 0;
}

