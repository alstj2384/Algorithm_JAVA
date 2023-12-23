n = int(input())
count = 0

for i in range(n+1):
    for j in range(60):
        for k in range(60):
            if k%10 == 3 or k // 10 == 3:
                count += 1
                continue
            if j%10 == 3 or j // 10 == 3:
                count += 1
                continue
            if i % 10 == 3:
                count += 1
                continue


print(count)
