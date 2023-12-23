c, n = map(int, input().split())

lst = sorted([int(input()) for _ in range(n)])

d = [1001] * 1001

if c > 0:
    for i in lst:

        d[i] = 1

for i in range(1, c+1):
    for j in range(n):
        if i - lst[j] > 0:
            d[i] = min(d[i], d[i - lst[j]]+1)

print(d[c])
