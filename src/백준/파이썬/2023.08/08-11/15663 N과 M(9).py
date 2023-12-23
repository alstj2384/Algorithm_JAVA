N, M = map(int, input().split())

num = sorted(list(map(int, input().split())))
ans = []
visited = [0] * (N)


def BT(n, lst):
    if n == M:
        ans.append(lst)
        return

    prev = 0
    for j in range(N):
        if visited[j] == 0 and prev != num[j]:
            prev = num[j]
            visited[j] = 1
            BT(n+1, lst + [num[j]])
            visited[j] = 0


BT(0, [])
for lst in ans:
    print(*lst)