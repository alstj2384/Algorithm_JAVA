n, m = map(int, input().split())

data = list(input().split())

q = 0
tmp = 0
for i in range(0, n-2):
    for j in range(i+ 1 , n - 1):
        for k in range(j + 1 ,n):
            if int(data[i])+int(data[j])+int(data[k]) <= m and int(data[i])+int(data[j])+int(data[k]) > tmp:
                tmp = int(data[i])+int(data[j])+int(data[k])

print(tmp)

