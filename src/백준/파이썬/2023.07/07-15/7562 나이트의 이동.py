from collections import deque

dx = [2, 2, -2, -2, 1, 1, -1, -1]
dy = [1, -1, 1, -1, 2, -2, 2, -2]

n = int(input())


def bfs():
    queue = deque()
    m = int(input())
    x, y = map(int, input().split())
    defx, defy = map(int, input().split())

    if x == defx and y == defy:
        return 0
    visited = [[False for i in range(m)] for i in range(m)]
    queue.append((x, y, 0))

    while queue:
        x, y, c = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= m or ny >= m:
                continue
            if visited[nx][ny]:
                continue
            visited[nx][ny] = True
            if nx == defx and ny == defy:
                return c+1
            queue.append((nx, ny, c+1))
            visited[nx][ny] = True


for i in range(n):
    print(bfs())




