import sys

n, m = map(int, input().split())

graph = [[0] * (n+1) for _ in range(n+1)]
graph2 = [[0] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = 1
    graph[b][a] = 1


# for a in range(1, n+1):
#     for b in range(1, n+1):
#         if graph[a][b] == 0:
#             print("0", end = " ")
#         else:
#             print(graph[a][b], end= " ")
#     print()

print()
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph2[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for a in range(1, n+1):
    for b in range(1, n+1):
        if graph2[a][b] == 0:
            print("0", end = " ")
        else:
            print(graph2[a][b], end= " ")
    print()