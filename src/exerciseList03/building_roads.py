from collections import deque

def achar_componentes():
    for v in range(1, n + 1):
        if not visitados[v]:
            componentes.append(v)
            busca(v)

def busca(inicial):
    visitados[inicial] = True
    fila.append(inicial)

    while fila:
        cidade_atual = fila.popleft()

        for conexao in adjacencias[cidade_atual]:
            if not visitados[conexao]:
                fila.append(conexao)
                visitados[conexao] = True

entrada = input().split()
n = int(entrada[0])
m = int(entrada[1])

componentes = []
adjacencias = [[] for _ in range(n+1)]
visitados = [False] * (n + 1)

for _ in range(m):
    c1, c2 = map(int, input().split())
    adjacencias[c2].append(c1)
    adjacencias[c1].append(c2)

fila = deque()

achar_componentes()

primeiro_vertice = componentes[0]
arestas = []
for i in range(1, len(componentes)):
    arestas.append((primeiro_vertice, componentes[i]))
    primeiro_vertice = componentes[i]

print(len(arestas))
for aresta in arestas:
    print(*aresta)
