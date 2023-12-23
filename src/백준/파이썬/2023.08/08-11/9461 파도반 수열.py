d = [0] * 101

n = int(input())
T = []
for i in range(n):
    T.append(int(input()))

d[0] = 0
d[1] = 1
d[2] = 1
d[3] = 1
d[4] = 2
for i in range(5, max(T)+1):
    d[i] = d[i-1] + d[i-5]

for i in T:
    print(d[i])