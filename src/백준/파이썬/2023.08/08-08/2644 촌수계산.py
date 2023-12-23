n = int(input())
a, b = map(int, input().split())

graph = [[] for i in range(n + 1)]
visited = [False] * (n+1)

for i in range(int(input())):
    x, y = map(int, input().split())
    graph[y].append(x)
    graph[x].append(y)

count = 0
def dfs(start, end, cnt):
    global count
    if not visited[start]:
        visited[start] = True

        if start == end:
            count = cnt
        for i in graph[start]:
            dfs(i, end, cnt + 1)

dfs(a, b, 0)
if count == 0:
    print(-1)
else:
    print(count)