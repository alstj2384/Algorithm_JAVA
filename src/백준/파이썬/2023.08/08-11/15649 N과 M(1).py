N, M = map(int,input().split())

ans = []
visited = [0] * (N + 1)


def BT(n, lst):
    if n == M:
        ans.append(lst)
        return
    for i in range(1, N + 1):
        if visited[i] == 0:
            visited[i] = 1
            BT(n+1, lst + [i])
            visited[i] = 0


BT(0, [])

for lst in ans:
    print(*lst)

