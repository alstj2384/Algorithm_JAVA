n, m = map(int, input().split())
parent = [0] * (n+1)

for i in range(0, n+1):
    parent[i] = i


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


graph = []
for _ in range(m):
    a, b, cost = map(int, input().split())
    graph.append((cost, a, b))

graph.sort()
sum = 0
for node in graph:
    # node[1] node[2] = a ,b
    if find_parent(parent, node[1]) != find_parent(parent, node[2]):
        union_parent(parent, node[1], node[2])
        sum += node[0]
        last = node[0]

print(sum - last)