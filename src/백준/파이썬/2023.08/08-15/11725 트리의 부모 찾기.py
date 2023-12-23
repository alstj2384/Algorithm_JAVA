from collections import deque
n = int(input())

graph = [[] for i in range(n + 1)]
for i in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

parent = [-1] * (n + 1)
parent[1] = 0

q = deque([1])
while q:
    x = q.popleft()
    for i in graph[x]:
        if parent[i] == -1:
            parent[i] = x
            q.append(i)

for i in range(2, n+1):
    print(parent[i])