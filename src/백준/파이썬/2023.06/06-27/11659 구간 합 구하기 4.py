import sys

n, m = list(map(int, input().split()))
num_li = list(map(int, input().split()))

sum_li = [0]
sum_num = 0
for i in num_li:
    sum_num += i
    sum_li.append(sum_num)

for i in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    print(sum_li[b] - sum_li[a-1])