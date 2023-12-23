input_data = input()
row = int(input_data[1])
col = int(ord(input_data[0])) - int(ord('a')) + 1

steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (1, 2), (1, -2), (-1, 2), (-1, -2)]
count = 0
for step in steps:
    if (row + step[0] > 0 and row + step[0] < 9) and (col + step[1] > 0 and col + step[1] < 9):
            count += 1


print(count)

