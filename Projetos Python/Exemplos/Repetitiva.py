x: int
soma: int

soma = 0

x = int(input("Digite o primeiro número"))

while x != 0:
    x = int(input("Digite outro número: "))
    soma = soma + x

print(f"Soma dos números digitados: {soma}")