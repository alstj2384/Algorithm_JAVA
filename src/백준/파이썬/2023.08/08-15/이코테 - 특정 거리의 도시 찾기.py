import sys
input = sys.stdin.readline

from collections import deque

n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]
visited = [-1] * (n + 1)
visited[x] = 0

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

queue = deque([x])

while queue:
    now = queue.popleft()
    for next_node in graph[now]:
       if visited[next_node] == -1:
           visited[next_node] = visited[now] + 1
           queue.append(next_node)

check = False
for i in range(n+1):
    if visited[i] == k:
        print(i)
        check = True

if not check:
    print(-1)


