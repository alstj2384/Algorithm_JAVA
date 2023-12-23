# 11:34

t = int(input())


d = [0] * 211


for i in range(0, 14):
    d[i] = i+1


for i in range(14, 211):
    if i % 14 == 0:
        d[i] = 1
        continue
    d[i] = d[i-14] + d[i-1]


for i in range(t):
    k = int(input())
    n = int(input())
    print(d[k*14+n-1])
