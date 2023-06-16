import heapq

def dijkstra(n, m):
    tamanho = n + 1
    adjacentes = [[] for _ in range(tamanho)]
    distancia = [float("inf")] * tamanho
    visitados = [False] * tamanho

    for _ in range(m):
        a, b, c = map(int, input().split())
        adjacentes[a].append((c, b))

    pq = []
    heapq.heapify(pq)

    def push(pq, item):
        heapq.heappush(pq, item)

    def pop(pq):
        return heapq.heappop(pq)

    push(pq, (0, 1))
    distancia[1] = 0

    while pq:
        _, vertice = pop(pq)

        if not visitados[vertice]:
            visitados[vertice] = True

            for aresta in adjacentes[vertice]:
                distancia_atual, vertice_atual = aresta

                if distancia[vertice_atual] > distancia[vertice] + distancia_atual:
                    distancia[vertice_atual] = distancia[vertice] + distancia_atual
                    new_tuple = (distancia[vertice_atual], vertice_atual)
                    push(pq, new_tuple)

    return distancia[1:]

entrada = input().split()
cities = int(entrada[0])
conexoes = int(entrada[1])
distancias = dijkstra(cities, conexoes)

for distancia in distancias:
    print(distancia, end=" ")
print()
