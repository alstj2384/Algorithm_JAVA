
n = int(input())

array = list(map(int, input().split()))
count = 0

for i in array:
    flag = False
    if i == 1:
        continue
    for j in range(2, i):
        if i % j == 0:
            flag = True
            break
    if not flag:
        count += 1

print(count)