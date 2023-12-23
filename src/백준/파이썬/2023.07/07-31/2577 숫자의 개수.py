a = int(input())
b = int(input())
c = int(input())

num = [0] * 10

abc = str(a*b*c)
for i in range(len(abc)):
    num[int(abc[i])] += 1

for i in num:
    print(i)