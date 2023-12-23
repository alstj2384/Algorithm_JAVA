from collections import deque

m, n = map(int, input().split())

# 시작 = 0,0 끝 = n-1, m-1

graph = []

for i in range(n):
    graph.append(list(map(int,input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


def bfs():
    queue = deque()
    queue.append((0, 0, 0))
    visited = [[False for i in range(m)] for j in range(n)]
    while queue:
        x, y, c = queue.popleft()
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m or visited[nx][ny]:
                continue
            if graph[nx][ny] == 0:
                queue.appendleft((nx, ny, c))
                visited[nx][ny] = True
                if nx == n-1 and ny == m-1:
                    return c
            else:
                queue.append((nx, ny, c+1))
                visited[nx][ny] = True

a = bfs()
if a == None:
    a = 0

print(a)