import sys
input = sys.stdin.readline

n = int(input())

data = list(map(int, input().split()))

m = int(input())

find = list(map(int, input().split()))

data = sorted(data)
find = sorted(find)


def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2

    if array[mid] == target:
        return mid

    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    elif array[mid] < target:
        return binary_search(array,target, mid+1, end)


for i in find:
    if binary_search(data, i, 0, len(data)-1) != None:
        print("yes")
    else:
        print("no")
