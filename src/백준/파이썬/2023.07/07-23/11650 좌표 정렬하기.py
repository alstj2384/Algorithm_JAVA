import sys
input = sys.stdin.readline

n = int(input())

array = []
for i in range(n):
    array.append(list(map(int, input().split())))

array = sorted(array, key = lambda x : (x[0], x[1]))

for a in array:
    print(f"{a[0]} {a[1]}")