#include <bits/stdc++.h>

using namespace std;

int main()
{
    int i, j, N, M;

    cout << "Qual a ordem da matriz? ";
    cin >> N;

    M = N;

    int mat[N][M];

    for(i = 0; i < N; i++){
        for(j = 0; j < M; j++){
            cout << "Elemento [ " << i <<  ", " << j << "]: ";
            cin >> (mat[i][j]);
        }
    }


    cout << "DIAGONAL PRINCIPAL:\n";

    for(i = 0; i < N; i++){
        cout << mat[i][i] << " ";
    }

    int neg;
    neg = 0;

    for(i = 0; i < N; i++){
        for(j = 0; j < M; j++){
            if (mat[i][j] < 0) {
                neg = neg + 1;
            }
        }
    }

    cout << "\nQUANTIDADE DE NEGATIVOS = " << neg;

    return 0;
}

