from collections import deque
import sys

input = sys.stdin.readline

graph = []
n = int(input())
for i in range(n):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]





visited = [[0 for i in range(n)] for j in range(n)]


def visit_bfs(x, y):
    if visited[x][y] or graph[x][y] == 0:
        return False
    visited[x][y] = True
    queue = deque()
    queue2 = deque() # 큐 저장용
    queue.append((x, y))
    queue2.append((x, y, 0))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue

            if graph[nx][ny] == 1 and visited[nx][ny] == 0:
                queue.append((nx, ny))
                queue2.append((nx, ny, 0))
                visited[nx][ny] = True
    return check_bfs(queue2)


def check_bfs(queue):
    min_dist = int(10e9)
    visit_zero = [[0 for i in range(n)] for j in range(n)]
    while queue:
        x, y, c = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[nx][ny] == 0 and visit_zero[nx][ny] == 0:
                queue.append((nx, ny, c + 1))
                visit_zero[nx][ny] = True
            if graph[nx][ny] == 1 and visited[nx][ny] == 0:
                return min(c, min_dist)
    return False

# 큐를 두 개를 써서, 하나는 visited 체킹용 하나는 해당 섬 스택 저장, 그리고 visit 이후
# 그 큐에 적힌 타일을 방문



min_dist = int(10e9)
for i in range(n):
    for j in range(n):
        if (a := visit_bfs(i,j)):
            min_dist = min(min_dist, a)

print(min_dist)

# 45분, 리팩토링 필요