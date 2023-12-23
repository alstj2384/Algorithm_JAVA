n = int(input())
lst = [0] + list(map(int, input().split()))

dp = [-1001] * (n + 1)
dp[1] = lst[1]

for i in range(2, n+1):
    dp[i] = max(dp[i-1] + lst[i], lst[i])

print(max(dp))