import heapq

n = int(input())
s = list(map(int, input().split()))

# k의 용도 : index 기록용, heapq에 튜플로 같이 들어갈 예정이고, result에 위치기록용으로 사용됨
k = len(s) - 1

result = [0] * n

q = []

while True: # 임시 루프 나중에 바꿔야함
    if s:
        a = s.pop()
        if not s:
            break
        if a <= s[-1]:
            result[k] = k
        else:
            heapq.heappush(q, (a, k))
        while q and q[0][0] <= s[-1]:
            a, b = heapq.heappop(q)
            result[b] = k
        k -= 1

print(" ".join(list(map(str, result))))

