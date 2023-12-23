n, k = map(int, input().split())


arrayA = list(map(int, input().split()))
arrayB = list(map(int, input().split()))

arrayA = sorted(arrayA)
arrayB = sorted(arrayB, reverse= True)

for i in range(k):
    if arrayA[i] < arrayB[i]:
        arrayA[i], arrayB[i] = arrayB[i], arrayA[i]
    else:
        break

print(sum(arrayA))

