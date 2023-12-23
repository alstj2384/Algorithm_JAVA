n, m = map(int, input().split()) # n 회사의 개수, m 경로의 개수
INF = int(10e9)
graph = [[INF for _ in range(n+1)] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j :
            graph[i][j] = 0


for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

x, k = map(int ,input().split())

if graph[k][x] == INF or graph[1][k] == INF:
    print(-1)
else: print(graph[k][x] + graph[1][k])