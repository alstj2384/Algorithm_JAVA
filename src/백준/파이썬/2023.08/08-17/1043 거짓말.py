n, m = map(int, input().split())

L = list(map(int, input().split()))
lie = 0


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def all_union_parent(parent, lst):
    for i in range(len(lst)-1):
        union_parent(parent, lst[i], lst[i+1])
    return find_parent(parent, lst[0])


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

if L[0] != 0:
    L = L[1:]
    all_union_parent(parent, L)
party = [[] for _ in range(m)]


for i in range(m):
    party[i] = list(map(int, input().split()))[1:]


for p in party:
    all_union_parent(parent, p)

for p in party:
    flag = False
    for i in p:
        if find_parent(parent, i) == find_parent(parent, L[0]):
            flag = True
    if not flag:
        lie += 1
print(lie)


"""
제출 기록 (누적 문제 풀이 시간 - 제출 결과)
55분 - 실패
75분 - 실패 
115분 - 실패(union-find로 변경)
120분 - 성공
"""