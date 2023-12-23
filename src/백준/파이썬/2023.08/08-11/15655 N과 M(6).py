N, M = map(int, input().split())

num = [0] + sorted(list(map(int, input().split())))
visited = [0] * (N + 1)
ans = []
def BT(n, s, lst):
    if n == M :
        ans.append(lst)
        return

    for j in range(s, len(num)):
        if visited[j] == 0:
            visited[j] = 1
            BT(n + 1, j, lst + [num[j]])
            visited[j] = 0

BT(0,1, [])
for lst in ans:
    print(*lst)
