n = int(input())

graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

d = [[0 for i in range(n)] for _ in range(n)]


if n != 1:

    d[0][0] = graph[0][0]
    d[1][0] = graph[1][0] + d[0][0]
    d[1][1] = graph[1][1] + d[0][0]
    for i in range(2, n):
        for j in range(i+1):
            if j == 0:
                d[i][j] = d[i-1][0] + graph[i][j]
                continue
            d[i][j] = max(d[i-1][j-1], d[i-1][j])+graph[i][j]

if n == 1:
    print(graph[0][0])
else :print(max(d[n-1]))