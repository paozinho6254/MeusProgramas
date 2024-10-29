#include <bits/stdc++.h>

using namespace std;

int main()
{

    double b, h, area, per, diag;

    cout << "Base do retangulo: ";
    cin >> (b);
    cout << "Altura do retangulo: ";
    cin >> (h);

    area = h * b;
    per = (h*2) + (b*2);
    diag = sqrt((h*h) + (b*b));

    cout << fixed << setprecision(4);
    cout << "Area = " << area << endl;
    cout << fixed << setprecision(4);
    cout << "Perimetro = " << per << endl;
    cout << fixed << setprecision(4);
    cout << "Diagonal = " << diag << endl;

    return 0;
}

