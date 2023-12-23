n, m = map(int, input().split())

graph = []

r, c, d = map(int, input().split())

dx = [-1, 0, 1, 0] # 북 동 남 서
dy = [0, 1, 0, -1]

for i in range(n):
    graph.append(list(map(int, input().split())))

count = 0
def clean(x, y, c):
    global count
    if graph[x][y] == 0:
        graph[x][y] = 2
        count += 1
    flag = False

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if graph[nx][ny] == 0:
            flag = True
            break

    if flag:
        while True:
            c = (c + 3) % 4
            nx = x + dx[c]
            ny = y + dy[c]

            if graph[nx][ny] == 0:
                return clean(nx, ny, c)
    else:
        nx = x + dx[(c + 2) % 4]
        ny = y + dy[(c + 2) % 4]

        if graph[nx][ny] == 0 or graph[nx][ny] == 2:
            return clean(nx, ny, c)
        elif graph[nx][ny] == 1:
            return

clean(r, c, d)

print(count)