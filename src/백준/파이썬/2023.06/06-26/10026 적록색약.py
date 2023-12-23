import copy
import sys
sys.setrecursionlimit(10**6)
n = int(input())

grid = []
for _ in range(n):
    grid.append(list(input()))

grid2 = copy.deepcopy(grid)

for i, row in enumerate(grid2):
    for c, val in enumerate(row):
        if val == 'G':
            grid2[i][c] = 'R'

RGB = ['R', 'G', 'B']


def dfs(grid, x, y, color):
    if x < 0 or y < 0 or x >= n or y >= n:
        return False
    if grid[x][y] == color:
        grid[x][y] = 0
        dfs(grid, x+1, y, color)
        dfs(grid, x, y+1, color)
        dfs(grid, x-1, y, color)
        dfs(grid, x, y-1, color)
        return True
    return False


result = 0

for i in range(n):
    for j in range(n):
        for k in RGB:
            if dfs(grid, i, j, k):
                result += 1

print(result)

result = 0

for i in range(n):
    for j in range(n):
        for k in RGB:
            if dfs(grid2, i, j, k):
                result += 1


print(result)