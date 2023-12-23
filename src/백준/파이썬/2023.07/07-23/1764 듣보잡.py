import sys
input = sys.stdin.readline

no_hear = dict()
array = []

n, m = map(int, input().split())

for i in range(n):
    a = input().rstrip()
    no_hear[a] = 1

for i in range(m):
    a = input().rstrip()
    if a in no_hear:
        array.append(a)

array = sorted(array)

print(len(array))
for i in array:
    print(i)