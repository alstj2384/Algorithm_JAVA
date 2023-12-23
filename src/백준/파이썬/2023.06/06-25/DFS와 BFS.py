from collections import deque

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, v, visited):
    visited[v] = True
    queue = deque([v])
    while queue:
        t = queue.popleft()
        print(t, end=' ')
        for i in graph[t]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]
visited = [False] * (n + 1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


for i in range(n+1):
    graph[i].sort()

dfs(graph, v, visited)
visited = [False] * (n + 1)
q = deque
print('')
bfs(graph, v, visited)