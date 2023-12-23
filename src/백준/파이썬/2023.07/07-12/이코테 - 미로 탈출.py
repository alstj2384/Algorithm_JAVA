n, m = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input())))


def dfs(x, y, count):
    if x < 0 or x >= n or y < 0 or y >= m:
        return False

    if graph[x][y] == 1:
        graph[x][y] = count
        dfs(x+1, y, count + 1)
        dfs(x, y+1, count + 1)
        dfs(x-1, y, count + 1)
        dfs(x, y-1, count + 1)
        return True
    return False


dfs(0, 0, 1)

print(graph[n-1][m-1])
