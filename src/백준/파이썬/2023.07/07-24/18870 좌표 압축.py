import sys
input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))
array = sorted(set(a))

dic_arr = dict()

for i, c in enumerate(array):
    dic_arr[c] = i

for i in a:
    print(dic_arr[i], end = ' ')


import sys
input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))
array = []
for i in a:
    if i in array:
        continue
    array.append(i)

dic_arr = dict()

array.sort()

for i, c in enumerate(array):
    dic_arr[c] = i

for i in a:
    print(dic_arr[i], end = ' ')

