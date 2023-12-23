import sys
input = sys.stdin.readline

array = dict()
n = int(input())

for i in list(map(int, input().split())):
    if i not in array:
        array[i] = 1
    else:
        array[i] = array[i] + 1

m = int(input())

for i in list(map(int, input().split())):
    if i not in array:
        print(0, end = ' ')
    else: print(array[i], end = ' ')