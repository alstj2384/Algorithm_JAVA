d = [0] * 10001
a, k = 0, 0
p = 10000
for i in range(1, p+1):
    n = len(str(i))
    k = i
    if d[i] == 0:
        while k < p+1:
            for j in range(n):
                a += int(str(k)[j])
            if k+a <= 10000:
                d[k+a] = 1

            k = a+k
            n = len(str(k))
            a = 0

for i in range(1, 10001):
    if d[i] == 0:
        print(i)

