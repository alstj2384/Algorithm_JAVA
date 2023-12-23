from collections import deque
n, m = map(int, input().split())

graph = []
queue = deque()
visited = [[0 for _ in range(m)] for _ in range(n)]

for i in range(n):
    graph.append(list(map(int, input().split())))
    if 2 in graph[i]:
        queue.append((i, graph[i].index(2), 0))
        visited[i][graph[i].index(2)] = True

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

while queue:
    a, b, c = queue.popleft()
    graph[a][b] = c
    for i in range(4):
        nx = a + dx[i]
        ny = b + dy[i]

        if nx < 0 or ny < 0 or nx >= n or ny >= m or graph[nx][ny] == 0:
            continue
        if visited[nx][ny]:
            continue
        visited[nx][ny] = True

        queue.append((nx, ny, c+1))


# not visited중에서 1인것
for i in range(n):
    for j in range(m):
        if visited[i][j] == False and graph[i][j] == 1:
            graph[i][j] = -1


for i in graph:
    for j in i:
        print(j, end = ' ')
    print()