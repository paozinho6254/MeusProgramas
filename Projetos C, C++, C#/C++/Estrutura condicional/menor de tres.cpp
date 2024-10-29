#include <bits/stdc++.h>

using namespace std;

int main()
{

   int X, Y, Z, menor;

   cout << "Primeiro Valor: ";
   cin >> (X);
   menor = X;

   cout << "Segundo Valor: ";
   cin >> (Y);
   if (Y < menor) {
        menor = Y;
   }
   cout << "Terceiro Valor: ";
   cin >> (Z);
   if (Z < menor) {
        menor = Z;
   }

   cout << "Menor = " << (menor);
    return 0;
}

