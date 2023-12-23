num = [0] * 10

room_num = input()

for i in range(len(room_num)):
    num[int(room_num[i])] += 1

if num[6] + num[9] > 1:
    if (num[6] + num[9]) % 2 == 1:
        num[9] = num[6] = (num[6] + num[9]) // 2+1
    else: num[9] = num[6] = (num[6] + num[9]) // 2

print(max(num))