n = int(input())

cnt = 0


for i in range(1, n+1):
    flag = False
    if i > 9:
        tmp = int(str(i)[0]) - int(str(i)[1])
        for j in range(1, len(str(i))-1):
            if tmp != int(str(i)[j]) - int(str(i)[j+1]):
                flag = True
                break
        if not flag:
            cnt += 1
    else:
        cnt += 1

print(cnt)
