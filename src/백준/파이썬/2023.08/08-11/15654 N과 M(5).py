N, M = map(int, input().split())

num = sorted(list(map(int, input().split())))
visited = [0] * (N + 1)
ans = []
def BT(n, lst):
    if n == M :
        ans.append(lst)
        return

    for j, c in enumerate(num):
        if visited[j] == 0:
            visited[j] = 1
            BT(n + 1, lst + [c])
            visited[j] = 0

BT(0, [])
for lst in ans:
    print(*lst)
