N, M = map(int, input().split())

num = [0] + sorted(list(map(int, input().split())))
ans = []


def BT(n, s, lst):
    if n == M:
        ans.append(lst)
        return

    for j in range(s, N + 1):
        BT(n+1, j, lst + [num[j]])


BT(0, 1, [])
for lst in ans:
    print(*lst)