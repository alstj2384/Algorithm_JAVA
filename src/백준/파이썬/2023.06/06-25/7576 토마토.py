from collections import deque

m, n = map(int, input().split())
tomato = []
queue = deque()
for i in range(n):
    line = list(map(int, input().split()))
    for j, ch in enumerate(line):
        if ch == 1:
            queue.append((i, j))
    tomato.append(line)

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if tomato[nx][ny] == -1:
                continue
            if tomato[nx][ny] == 0:
                tomato[nx][ny] = tomato[x][y] + 1
                queue.append((nx, ny))
    return 0


bfs()
result = 0
for i in tomato:
    if 0 in i:
        result = -1
        break
    elif max(i) >= result + 1:
        result = max(i) - 1
print(result)
