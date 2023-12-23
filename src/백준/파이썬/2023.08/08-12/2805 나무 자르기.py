n, m = map(int , input().split())

tree = list(map(int, input().split()))

lo = 0
hi = max(tree)


while lo < hi:
    mid = (lo + hi) // 2 + 1
    s = sum([max(0, x - mid) for x in tree])

    if s >= m:
        lo = mid
    else:
        hi = mid - 1

print(lo)

