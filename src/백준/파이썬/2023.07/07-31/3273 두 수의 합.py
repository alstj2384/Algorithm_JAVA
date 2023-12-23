import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))
k = int(input())

array = sorted(array)

a = 0
b = len(array)-1
count = 0

while True:
    if a >= b:
        break
    ab = array[a] + array[b]
    if ab == k:
        a += 1
        b -= 1
        count += 1
    elif ab > k:
        b -= 1
    elif ab < k:
        a += 1
# k보다 크면 b를 낮추고 k보다 작으면 a를 올리고
print(count)


