#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main()
{

    double Base, lag, meter, area, valor;

    cout << "Digite a largura do terreno: ";
    cin >> (lag);
    cout << "Digite o comprimento do terreno: ";
    cin >> (Base);
    cout << "Digite o comprimento do terreno: ";
    cin >> (meter);

    area = Base * lag;
    valor = area * meter;

    cout << fixed << setprecision(2);
    cout << "Area do terreno = " << area << endl;
    cout << fixed << setprecision(2);
    cout << "Preco do terreno = " << valor << endl;
    return 0;
}
