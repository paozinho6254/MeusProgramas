
soma = 0
N = int(input("Quantos números serão digitados? "))
for i in range (0,N):
    x = int(input("Digite um número"))
    soma = soma + x

print(f"Soma dos números digitados: {soma}")