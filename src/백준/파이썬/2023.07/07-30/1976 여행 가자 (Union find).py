import sys
sys.setrecursionlimit(10**5)


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
m = int(input())

parent = [0] * (n + 1)
for i in range(1, n+1):
    parent[i] = i
array = []

for i in range(n):
    array.append(list(map(int, input().split())))

for i in range(n-1):
    for j in range(i+1, n):
        if array[i][j] == 1:
            union_parent(parent, i+1, j+1)

visit_list = list(map(int, input().split()))

a = find_parent(parent, visit_list[0])
for i in visit_list:
    if a != find_parent(parent, i):
        print("NO")
        exit(0)
print("YES")