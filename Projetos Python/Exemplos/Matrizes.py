M = int(input("Quantas linhas teram na matríz? "))
N = int(input("Quantas colunas teram na matríz? "))

mat: [[int]] = [[0 for x in range(N)]for x in range(M)]

for i in range(0, M):
    for j in range(0, N):
        mat[i][j] = int(input(f"Elemento [ {i}, {j}]: "))

print()
print("Matríz digitada: ")
for i in range(0, M):
    for j in range(0, N):
        print(f"{mat[i][j]} ", end="")
    print()