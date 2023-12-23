n, m = map(int, input().split())

lst = [int(input()) for _ in range(n)]

lo , hi = 0, max(lst)

# s가 m과 같을 경우, 끝
# s가 m보다 큰 경우, lo = mid로 실행(최대값까지)
# s가 m보다 작은 경우, hi = mid - 1로 실행

while lo < hi:
    mid = (lo + hi) // 2 + 1
    # 10 // 11
    s = sum([x // mid for x in lst])

    if s >= m:
        lo = mid
    else:
        hi = mid-1
print(lo)