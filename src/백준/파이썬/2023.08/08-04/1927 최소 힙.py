import sys
import heapq
input = sys.stdin.readline

q = []
for i in range(int(input())):
    a = int(input())
    if a != 0:
        heapq.heappush(q, a)
    else:
        if q:
            print(heapq.heappop(q))
        else:
            print(0)