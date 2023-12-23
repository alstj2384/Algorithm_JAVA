n = int(input())

array = list(map(int, input().split()))

v = int(input())
count = 0
for i in array:
    if i == v:
        count += 1
print(count)
