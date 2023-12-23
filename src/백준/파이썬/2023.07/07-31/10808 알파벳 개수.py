alist = [0] * 26

a = input()

for i in range(len(a)):
     alist[ord(a[i]) - ord('a')] += 1

for i in range(len(alist)):
    print(alist[i], end = ' ')