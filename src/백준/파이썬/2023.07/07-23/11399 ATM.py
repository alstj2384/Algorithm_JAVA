n = int(input())

array = sorted(list(map(int, input().split())))

sum = 0
total = 0
for i in array:
    sum += i
    total += sum
print(total)
