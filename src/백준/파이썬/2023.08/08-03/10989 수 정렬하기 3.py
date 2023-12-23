import sys
input = sys.stdin.readline

n = int(input())

sort_array = [0] * 10001

for i in range(n):
    sort_array[int(input())] += 1

for i in range(10001):
    if sort_array[i] != 0:
        for j in range(sort_array[i]):
            print(i)