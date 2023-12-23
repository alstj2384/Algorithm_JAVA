from itertools import combinations_with_replacement

n = int(input())

sets = [1, 5, 10, 50]
result = []
for i in list(combinations_with_replacement(sets, n)):
    result.append(sum(i))

print(len(set(result)))

