n = int(input())

stair = [int(input()) for _ in range(n)]
d = [[0] * (n + 1) for i in range(2)]
d[1][1] = stair[0]
if n >= 2:
    d[0][2] = stair[0] + stair[1]
    d[1][2] = stair[1]

# 0인 경우 = 1칸으로 오른 경우
# 1인 경우 = 2칸으로 오른 경우
for i in range(3, n+1):
    d[1][i] = max(d[0][i-2], d[1][i-2]) + stair[i-1]
    d[0][i] = d[1][i-1] + stair[i-1]
print(max(d[0][n], d[1][n]))