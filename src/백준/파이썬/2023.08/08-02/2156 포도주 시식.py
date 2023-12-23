import sys
input = sys.stdin.readline
n = int(input())

lst = [0] + [int(input()) for i in range(n)]
dp = [[0] * (n + 1) for _ in range(2)]


# dp[0][i] = 연속해서 먹었던 경로
# dp[1][i] = 건너 뛰어서 먹었던 경로
dp[0][1] = lst[1]
if n >= 2:
    dp[1][2] = lst[2]
    dp[0][2] = lst[1] + lst[2]

for i in range(3, n + 1):
    dp[0][i] = dp[1][i-1] + lst[i]
    dp[1][i] = max(dp[0][i-2], dp[1][i-2]) + lst[i]

print(max(max(dp[0]), max(dp[1])))