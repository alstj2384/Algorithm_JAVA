N, M = map(int, input().split())

ans = []
visited = [0] * (N + 1)


def BT(n, lst, i):
    if n == M:
        ans.append(lst)
        return
    for j in range(i + 1, N + 1):
        if visited[j] == 0 :
            visited[j] = 1
            BT(n+1, lst + [j], j)
            visited[j] = 0


BT(0, [], 0)

for lst in ans:
    print(*lst)
