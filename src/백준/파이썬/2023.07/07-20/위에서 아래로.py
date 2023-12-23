n = int(input())

array = []
for i in range(n):
    array.append(int(input()))

for i in reversed(sorted(array)):
    print(i)