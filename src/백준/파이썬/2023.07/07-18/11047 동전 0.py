n, k = map(int,input().split())

coins = []

for i in range(n):
    coins.append(int(input()))

coins.reverse()
count = 0

for i in coins:
    a = k // i
    k = k - a * i
    count += a
    if k == 0:
        break

print(count)