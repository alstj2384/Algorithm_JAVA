import heapq
import sys
input = sys.stdin.readline


q = []
# -1, -1, 1, 2

for _ in range(int(input())):
    a = int(input())
    if a == 0:
        if q:
            a, b = heapq.heappop(q)
            if b == 1:
                print(a)
            else:
                print(-a)
        else:
            print(0)
    elif a < 0:
        heapq.heappush(q, (-a, 0)) # a, 부호
    else:
        heapq.heappush(q, (a, 1))



