dp = [[0 for i in range(2)] for j in range(41)]


# row, col (x, y)
dp[0][0] = 1
dp[0][1] = 0

dp[1][0] = 0
dp[1][1] = 1

# dp[i][0] = i번째에서 0이 나오는 횟수
# dp[i][1] = i번째에서 1이 나오는 횟수
for i in range(2, 41):
    dp[i][0] = dp[i-2][0] + dp[i-1][0]
    dp[i][1] = dp[i-2][1] + dp[i-1][1]

for i in range(int(input())):
    a = int(input())
    print(dp[a][0], end=' ')
    print(dp[a][1])