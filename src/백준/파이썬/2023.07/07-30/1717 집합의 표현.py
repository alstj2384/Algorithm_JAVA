import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline


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


n, m = map(int, input().split())

parent = [0] * (n + 1)

for i in range(1, n+1):
    parent[i] = i

for i in range(m):
    a, b, c = map(int, input().split())
    if a == 0:
        union_parent(parent, b, c)
    else:
        if find_parent(parent, b) == find_parent(parent, c):
            print("yes")
        else:
            print("no")



# 0 은 union, 1은 find 함수 호출
