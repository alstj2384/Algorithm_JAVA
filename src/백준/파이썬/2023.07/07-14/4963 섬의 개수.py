import sys
sys.setrecursionlimit(10**6)
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [0, 1, -1, 1, -1, 0, 1, -1]


def dfs(x, y):
    if graph[x][y] == 1:
        graph[x][y] = 0
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            dfs(nx, ny)
        return True
    return False


while True:
    m, n = map(int, input().split())
    if n == 0 and m == 0:
        break
    graph = []
    for i in range(n):
        graph.append(list(map(int, input().split())))

    count = 0
    for i in range(n):
        for j in range(m):
            if dfs(i, j):
                count += 1
    print(count)
    graph.clear()







