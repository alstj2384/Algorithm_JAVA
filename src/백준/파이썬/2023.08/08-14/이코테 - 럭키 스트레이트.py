n = input().rstrip()

half = len(n)//2

sum = 0
for i in n[:half]:
    sum += int(i)
for i in n[half:]:
    sum -= int(i)

if sum == 0:
    print("LUCKY")
else:
    print("READY")
