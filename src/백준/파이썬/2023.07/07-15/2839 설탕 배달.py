n = int(input())



d = [0] * 5001
d[0] = 5001
d[1] = 5001
d[2] = 5001
d[3] = 1
d[4] = 5001
d[5] = 1

for i in range(6, n+1):
    d[i] = min(d[i - 3],d[i-5])+1

print(-1) if d[n] >= 5001 else print(d[n])