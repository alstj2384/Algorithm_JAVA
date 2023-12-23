import sys
sys.setrecursionlimit(10**6)
n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(input()))

visited = [[False for _ in range(m)] for _ in range(n)]
count = [0]


def dfs(x, y):
    if x < 0 or y < 0 or x >= n or y >= m or visited[x][y] or graph[x][y] == 'X':
        return

    if graph[x][y] == 'P':
        count[0] += 1

    if not visited[x][y]:
        visited[x][y] = True
        dfs(x+1, y)
        dfs(x, y + 1)
        dfs(x-1, y)
        dfs(x, y -1)


for i in range(n):
    for j in range(m):
        if graph[i][j] == 'I':
            dfs(i,j)
            break


if count[0] == 0:
    print('TT')
else:
    print(count[0])
