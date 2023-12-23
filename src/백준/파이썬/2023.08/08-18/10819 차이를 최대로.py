n = int(input())
lst = sorted(list(map(int,input().split())))
visited = [0] * (n)
result= []
def dfs(m, k):
    if n == m:
        s = 0
        for i in range(1, m):
            s += abs(k[i]-k[i-1])
        result.append(s)
        return

    for j in range(0, n):
        if visited[j] == 0:
            visited[j] = 1
            dfs(m+1, k + [lst[j]])
            visited[j] = 0

dfs(0, [])
print(max(result))