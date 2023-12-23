import sys
input = sys.stdin.readline
n, m = map(int, input().split())

dic = {}
for i in range(1, n+1):
    a = input().rstrip()
    dic[a] = i
    dic[str(i)] = a

for i in range(m):
    a = input().rstrip()
    if a in dic:
        print(dic[a])
