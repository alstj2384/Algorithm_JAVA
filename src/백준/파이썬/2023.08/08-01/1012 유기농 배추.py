import sys
sys.setrecursionlimit(10**6)


def dfs(x, y):
    if array[x][y] == 1:
        array[x][y] = 0

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if array[nx][ny] == 1:
                dfs(nx, ny)
        return True
    return False

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(int(input())):

    m, n, k = map(int, input().split())
    array = [[0 for i in range(m)] for j in range(n)]

    for i in range(k):
        a, b = map(int, input().split())
        array[b][a] = 1

    count = 0
    for i in range(n):
        for j in range(m):
            if dfs(i, j):
                count += 1
    print(count)

