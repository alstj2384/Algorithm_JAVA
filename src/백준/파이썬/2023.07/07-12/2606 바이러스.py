n = int(input())
m = int(input())

graph = [[0 for _ in range(n+1)] for _ in range(n+1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1


def dfs(start):
    visited[start] = True
    for i in range(len(graph[start])):
        if graph[start][i] == 1 and not visited[i]:
            dfs(i)


count = 0
dfs(1)
for i in visited:
    if i:
        count += 1

print(count-1)
