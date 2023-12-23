import sys
input = sys.stdin.readline


n, m = map(int, input().split())
Dic = {}

for i in range(n):
    a, b = input().split()
    Dic[a] = b

for i in range(m):
    a = input().rstrip()
    print(Dic[a])
