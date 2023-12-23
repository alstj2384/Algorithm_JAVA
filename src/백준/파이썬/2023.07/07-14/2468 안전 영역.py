import sys
sys.setrecursionlimit(10**6)
n = int(input())

graph = []
height = 0
for i in range(n):
    graph.append(list(map(int, input().split())))
    tmp = max(graph[i])
    height = max(tmp, height)

# 시작은 0,0

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(x, y, h):
    if graph[x][y] <= h:
        return False
    if not visited[x][y]:
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            dfs(nx, ny, h)
        return True
    return False

count = 0
tmp = 0

for k in range(0, height):
    visited = [[False for i in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(n):
            if dfs(i, j, k):
                count += 1
    tmp = max(count, tmp)
    count = 0


print(tmp)