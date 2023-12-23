from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int,input().split())


def bfs(x, y):
    if array[x][y] == 0 or visited[x][y]:
        return False
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True
    while queue:
        a, b = queue.popleft()
        if array[a][b] == 0:
            continue

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True
    return True


array = []
grac = deque()

for i in range(n):
    array.append(list(map(int, input().split())))
    for j in range(len(array[i])):
        if array[i][j] != 0:
            grac.append((i, j, array[i][j]))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


year = 0
while True:

    # 쪼개짐 확인 여부 true이면 체크해야함
    visited = [[False for i in range(m)] for j in range(n)]
    year += 1
    change_list = []
    while grac:
        x, y, c = grac.popleft()
        count = 0
        for j in range(4):
            nx = x + dx[j]
            ny = y + dy[j]

            if array[nx][ny] == 0:
                count += 1
        c -= count
        if c <= 0:
            c = 0
        change_list.append((x, y, c))

    for cl in change_list:
        array[cl[0]][cl[1]] = cl[2]
        if cl[2] != 0:
            grac.append((cl[0], cl[1], cl[2]))

    count = 0
    for i in range(n):
        for j in range(m):
            if bfs(i, j):
                count += 1
    if count == 0:
        print('0')
        break
    elif count != 1:
        print(year)
        break



