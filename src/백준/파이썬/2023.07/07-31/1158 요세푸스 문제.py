from collections import deque

n, k = map(int, input().split())

circle = deque()

for i in range(1, n+1):
    circle.append(i)

array = []
count = 1
while circle:
    if k == count:
        array.append(circle.popleft())
        count = 1
    else:
        circle.append(circle.popleft())
        count += 1

print('<', end='')
for i in range(len(array)-1):
    print(f"{array[i]}, ", end='')

print(f"{array[len(array)-1]}>")