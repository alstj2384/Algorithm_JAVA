N, M = map(int, input().split())

ans = []
def BT(n, s, lst):
    if n == M:
        ans.append(lst)
        return

    for j in range(s, N+1):
        BT(n+1, j, lst+[j])

BT(0, 1, [])

for lst in ans:
    print(*lst)