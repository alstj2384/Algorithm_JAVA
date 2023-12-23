n = int(input())

array = []
for i in range(n):
    a, b = input().split()
    array.append((a, b))

array = sorted(array, key = lambda x: x[0])

for student in array:
    print(student[0], end=' ')


