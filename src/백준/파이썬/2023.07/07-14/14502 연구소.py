from collections import deque
from itertools import combinations
import copy

n, m = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))

db = [0] * (m*n)

for i in range(n):
    for j in range(m):
        db[i*m + j] = i*m + j

cb = list(combinations(db, 3))

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


def parse(t1):
    x1 = t1 // m
    y1 = t1 - (m * x1)
    return x1, y1


def bfs(visited, x, y):
    if graph[x][y] != 2 or visited[x][y]:
        return 0
    count = 1
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if not visited[nx][ny] and graph[nx][ny] == 0:
                queue.append((nx, ny))
                visited[nx][ny] = True
                count += 1
    return count


def call_bfs():
    count1 = 0
    count2 = 0

    visited = [[False for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            count2 += bfs(visited, i, j)
    for i in range(len(graph)):
        count1 += graph[i].count(1)
    return m*n - (count2 + count1)


def bfspre(t1, t2, t3):
    x1, y1 = parse(t1)
    x2, y2 = parse(t2)
    x3, y3 = parse(t3)
    if graph[x1][y1] != 0 or graph[x2][y2] != 0 or graph[x3][y3] != 0:
        return 0

    graph[x1][y1] = 1
    graph[x2][y2] = 1
    graph[x3][y3] = 1

    count = call_bfs()

    graph[x1][y1] = 0
    graph[x2][y2] = 0
    graph[x3][y3] = 0
    return count


count = 0

for i in cb:
    count = max(bfspre(i[0], i[1], i[2]), count)

print(count)