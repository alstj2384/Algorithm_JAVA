lst = [[i]+[int(input())] for i in range(1, 9)]
lst = sorted(lst, key = lambda x : x[1], reverse = True)

lst = sorted(lst[:5])
sum =0

for i in lst:
    sum += i[1]

print(sum)
for i in lst:
    print(i[0], end = ' ')



