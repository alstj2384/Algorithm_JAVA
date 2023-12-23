from collections import deque

# 불 -> 지훈이 순서로 확산시키자

n, m = map(int, input().split())

array = []
fire_list = []
for i in range(n):
    array.append(list(input().rstrip()))
    if 'J' in array[i]:
        a, b = i, array[i].index('J')

for i in range(n):
    for j in range(m):
        if array[i][j] == 'F':
            fire_list.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


visited = [[False for i in range(m)] for j in range(n)]
# x, y 는 지훈의 최초 위치
def bfs(x, y):
    queue = deque()
    queue.append((x, y, 0))
    visited[x][y] = True
    prev_count = -1
    count = int(1e9)
    while queue:
        x, y, c = queue.popleft()
        array[x][y] = 'J'
        if array[x][y] == 'F':
            continue

        if y == 0 or x == 0 or x == n-1 or y == m-1:
            return c

        if c != prev_count:
            fire()
            prev_count = c

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if array[nx][ny] == '.' and not visited[nx][ny]:
                queue.append((nx, ny, c + 1))
                visited[nx][ny] = True
    return count

# 4 4
# ####
# #FJF
# #...
# #...


fire_visit = [[False for i in range(m)] for i in range(n)]


def fire():
    new_fire_list = []
    while fire_list:
        i, j = fire_list.pop()
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if (array[nx][ny] == 'J' or array[nx][ny] == '.') and not fire_visit[nx][ny]:
                new_fire_list.append((nx, ny))
                fire_visit[nx][ny] = True

    for i in new_fire_list:
        array[i[0]][i[1]] = 'F'
        fire_list.append((i[0], i[1]))


if (p := bfs(a, b)) == int(1e9):
    print("IMPOSSIBLE")
else:
    print(p+1)
