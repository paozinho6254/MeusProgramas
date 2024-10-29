#include <bits/stdc++.h>

using namespace std;

int main()
{
    int i, N, cmen;
    double altm, medtl, meno;

    cout << "Quantas pessoas serao digitadas?";
    cin >> (N);

    int age[N];
    double alt[N];
    string nome[N];

    cmen = 0;
    altm = 0;

    for(i = 0; i < N; i++){
        cout << "Dados da " << i + 1 << "a pessoa:" << endl;
        cout << "Nome: ";
        cin.ignore(INT_MAX, '\n');
        getline(cin, nome[i]);
        cout << "Idade: ";
        cin >> (age[i]);
        if (age[i] < 16) {
            cmen = cmen + 1;
        }
        cout << "Altura";
        cin >> (alt[i]);
        altm = altm + alt[i];
        }
    }


    cout << fixed << setprecision(2);
    cout << "Altura média: " << altm << endl;
    cout << fixed << setprecision(1);
    cout << "Pessoas com menos de 16 anos: " << meno << "%" << endl;

    for(i = 0; i < N; i++) {
        if age[i] < 16 {
             cout << nome[i];
        }
    }

    return 0;
}

