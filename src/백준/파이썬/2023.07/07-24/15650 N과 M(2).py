from itertools import combinations

n , m = map(int, input().split())

for a in list(combinations(range(1, n+1), m)):
    for b in a:
        print(b, end = ' ')
    print()