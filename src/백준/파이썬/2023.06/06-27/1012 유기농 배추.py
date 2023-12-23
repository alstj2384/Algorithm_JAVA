import sys
sys.setrecursionlimit(10**6)
T = int(input())

result = []
grid = []
# 가로 m 세로 n

def dfs(x, y):
    if x < 0 or y < 0 or x >= m or y >= n :
        return

    if grid[x][y] == 1:
        grid[x][y] = 0
        dfs(x+1, y)
        dfs(x, y+1)
        dfs(x-1, y)
        dfs(x, y-1)
        return True
    return False


for _ in range(T):
    m, n, k = map(int, input().split())
    grid = [[0 for col in range(n)] for row in range(m)]

    for i in range(k):
        a, b = map(int, input().split())
        grid[a][b] = 1
    count = 0
    for i in range(n):
        for j in range(m):
            if dfs(j, i):
                count += 1
    grid.clear()
    result.append(count)

for i in range(T):
    print(result[i])