from itertools import combinations_with_replacement

n, m = map(int, input().split())

for a in list(combinations_with_replacement(range(1, n+1), m)):
    for b in a:
        print(b, end = ' ')
    print()