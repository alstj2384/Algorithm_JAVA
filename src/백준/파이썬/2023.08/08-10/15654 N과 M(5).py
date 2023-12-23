from itertools import permutations

n, m = map(int, input().split())

lst = list(map(int, input().split()))

for i in sorted(list(permutations(lst, m))):
    for j in i:
        print(j, end = ' ')
    print()
