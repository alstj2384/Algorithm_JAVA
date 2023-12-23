N, M = map(int, input().split())

ans = []
def BT(n, lst):
    if n == M:
        ans.append(lst)
        return

    for j in range(1, N+1):
        BT(n+1, lst+[j])

BT(0, [])

for lst in ans:
    print(*lst)