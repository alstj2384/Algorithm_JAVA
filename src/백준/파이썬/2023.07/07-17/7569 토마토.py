import sys
from collections import deque
input = sys.stdin.readline


m, n, h = map(int,input().split())

graph = []

queue = deque()

for i in range(h):
    tmp = []
    for j in range(n):
        tmp.append(list(map(int, input().split())))
        for k in range(m):
            if tmp[j][k] == 1:
                queue.append([i, j, k])
    graph.append(tmp)

dx = [0, 0, -1, 1, 0, 0]
dy = [0, 0, 0, 0, 1, -1]
dh = [-1, 1, 0, 0, 0, 0]


while queue:
    z, x, y = queue.popleft()

    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dh[i]

        if nx < 0 or nx >= n or ny < 0 or ny >= m or nz < 0 or nz >= h:
            continue
        if graph[nz][nx][ny] == 0:
            queue.append((nz, nx, ny))
            graph[nz][nx][ny] = graph[z][x][y] + 1


day = 0
for i in graph:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit(0)
        day = max(day, max(j))

print(day-1)