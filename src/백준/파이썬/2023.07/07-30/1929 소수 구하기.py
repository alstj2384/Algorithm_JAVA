import math
# 에라토스테네스의 체

n, m = map(int, input().split())


checked = [True for i in range(m+1)]
checked[1] = False

for i in range(2, int(math.sqrt(m))+1):
    if checked[i] == True:
        j = 2
        while i * j <= m:
            checked[i * j] = False
            j += 1

for i in range(n, m+1):
    if checked[i]:
        print(i)


