n = input()

lst = []
sum = 0

for i in n:
    if ord(i) >= ord('A') and ord(i) <= ord('Z'):
       lst.append(i)
    else:
        sum += int(i)

print("".join(sorted(lst)), end = '')
print(sum)