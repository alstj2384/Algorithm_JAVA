import sys
input = sys.stdin.readline

n = int(input())

array = []
for _ in range(n):
    array.append(input().rstrip())

array = list(set(array))
array = sorted(array)
array = sorted(array, key = lambda x : len(x))

for i in array:
    print(i)