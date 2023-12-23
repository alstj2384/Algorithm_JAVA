n, m = map(int, input().split())

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

parent = [0] * (n + 1)

for i in range(1, n+1):
    parent[i] = i

for i in range(m):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

result = []
for i in range(1, n+1):
    result.append(find_parent(parent, i))

print(len(set(result)))