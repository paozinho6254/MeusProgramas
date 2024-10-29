#include <bits/stdc++.h>

using namespace std;

int main()
{


   int X, Y, i, N, trade, top;

   top = 0;
   trade = 0;

   cout << "Digite dois numeros\n";
   cin >> X;
   cin >> Y;

   if (Y < X) {
        trade = Y;
        Y = X;
        X = trade;
   }

   N = Y;

   for(i = X; i < N; i++) {
        if (i % 2 != 0) {
            top = top + i;
        }
   }

   cout << "Soma dos impares = " << top;

    return 0;
}

