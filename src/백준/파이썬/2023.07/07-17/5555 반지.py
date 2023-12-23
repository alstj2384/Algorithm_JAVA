sent = input()

n = int(input())

count = 0
for i in range(n):
    a = input()
    if (a+a).find(sent) == -1:
        continue
    else: count += 1

print(count)