import sys
sys.setrecursionlimit(10**6)

n,m, k = map(int, input().split())

graph = [[0 for i in range(m)] for j in range(n)]

for i in range(k):
    ax, ay, bx, by = map(int, input().split())

    for i in range(ax, bx):
        for j in range(ay, by):
            graph[j][i] = 1

visited = [[0 for i in range(m)] for j in range(n)]


def dfs(x, y):
    if x < 0 or x >= n or y < 0 or y >= m:
        return 0
    if visited[x][y] == 0 and graph[x][y] == 0:
        visited[x][y] = True
        return 1 + dfs(x+1, y) + dfs(x , y+1) + dfs(x-1, y) + dfs(x, y-1)
    return 0

result = []
count = 0
for i in range(n):
    for j in range(m):
        if (a :=dfs(i, j)) != 0:
            count += 1
            result.append(a)

print(count)
print(" ".join(map(str, sorted(result))))
