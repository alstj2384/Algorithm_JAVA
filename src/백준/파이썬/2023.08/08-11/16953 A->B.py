a, b = map(int, input().split())

ans = []


def dfs(n, count):
    if n > int(10e9):
        return
    if n == b:
        ans.append(count)
        return
    dfs(n*2, count+1)
    dfs(int(str(n)+'1'), count+1)


dfs(a, 0)
if ans:
    print(min(ans)+1)
else:
    print(-1)