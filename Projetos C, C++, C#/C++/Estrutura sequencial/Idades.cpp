#include <bits/stdc++.h>

using namespace std;

int main()
{

   string N1, N2;
   double age1, age2, agem;

   cout << "Dados da primeira pessoa:" << endl;
   cout << "Nome: ";
    getline(cin, N1);
   cout << "Idade: ";
   cin >> (age1);
   cout << "Dados da segunda pessoa:" << endl;
   cout << "Nome: ";
   cin.ignore(INT_MAX, '\n');
    getline(cin, N2);
   cout << "Idade: ";
   cin >> (age2);

   agem = (age1 + age2)/2;

   cout << "A idade media de " << N1 << " e " << N2 << " e de " << agem << " anos.";

    return 0;
}

