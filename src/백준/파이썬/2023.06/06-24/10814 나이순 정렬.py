n = int(input())
table = []

for _ in range(n):
    age, name = map(str, input().split())
    table.append([int(age), name])

table.sort(key = lambda x : (x[0]))
for i in table:
    print(f"{i[0]} {i[1]}")

