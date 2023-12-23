n, m = map(int, input().split())

graph = []

visited = [[False for _ in range(m)] for _ in range(n)]
count = 0

countIn = 0


def dfs(x, y):
    global countIn
    if x < 0 or y < 0 or x >= n or y >= m:
        return
    if not visited[x][y]:
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                visited[x][y] = True
                countIn += 1
            else:
                dfs(nx, ny)
    return countIn


for i in range(n):
    graph.append(list(map(int, input().split())))

for i in range(len(graph)):
    count += graph[i].count(1)

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


count2 = 0

while True:
    visited = [[False for _ in range(m)] for _ in range(n)]
    tmp = count
    count -= dfs(0, 0)
    count2 += 1
    if count == 0:
        break


print(count2)
print(tmp)
