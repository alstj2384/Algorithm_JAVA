import heapq
import sys
input = sys.stdin.readline


q = []

for _ in range(int(input())):
    a = int(input())
    if a == 0:
        if q:
            a = heapq.heappop(q)
            print(-a)
        else:
            print(0)
    else:
        heapq.heappush(q, -a)



