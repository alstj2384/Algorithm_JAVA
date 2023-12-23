from collections import deque

n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int,input())))


dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y, count):
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[nx][ny] == 0:
                continue
            queue.append((nx, ny))
            count += 1
            graph[nx][ny] = 0
    return count


houses = [0] * (n*n)
cnt = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            houses[cnt] = bfs(i, j, 1)
            cnt += 1

houseCnt = []

for i in houses:
    if i != 0:
        houseCnt.append(i)

houseCnt.sort()

print(len(houseCnt))
for i in range(len(houseCnt)):
    print(houseCnt[i])
