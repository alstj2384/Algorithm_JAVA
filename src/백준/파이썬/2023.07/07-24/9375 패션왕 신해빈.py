from itertools import combinations


for i in range(int(input())):
    array = dict()
    for j in range(int(input())):
        a, b = input().split()

        if array.get(b, None) is None:
            array[b] = 1
        else:
            array[b] += 1

    sum = 1
    key_arr = list(array.keys())

    for key in key_arr:
        sum *= (array[key] + 1)

    sum -= 1

    print(sum)