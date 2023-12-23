

n = int(input())

visited = [[0 for i in range(n)] for j in range(n)]
check = [0 for _ in range(n)]


def dfs(a, b):
    if check[a] == 0:
        check[a] = 1
        for i, c in enumerate(graph[a]):
            if c == 1:
                visited[b][i] = 1
                dfs(i, b)


graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))


for i in range(n):
    check = [0 for _ in range(n)]
    dfs(i, i)

for j in range(n):
    for i in visited[j]:
        print(i, end=' ')
    print()