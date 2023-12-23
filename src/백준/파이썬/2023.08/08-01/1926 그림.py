from collections import deque

n, m = map(int, input().split())

array = []

for i in range(n):
    array.append(list(map(int, input().split())))


dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

visited = [[False for i in range(m)] for j in range(n)]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    count = 0

    while queue:
        x, y = queue.popleft()

        if not visited[x][y] and array[x][y] != 0:
            count += 1
            visited[x][y] = True
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= n or ny < 0 or ny >= m:
                    continue
                if array[nx][ny] == 1 and not visited[nx][ny]:
                    queue.append((nx, ny))

    return count


total = 0
max_area = 0
for i in range(n):
    for j in range(m):
        if (a := bfs(i, j)) != 0:
            total += 1
            max_area = max(a, max_area)

print(total)
print(max_area)