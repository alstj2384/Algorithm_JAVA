import sys
input = sys.stdin.readline

# 문자열 파싱 후 리스트에 담으면 일단 1단계 끝 나머지는 쉬울듯

for i in range(int(input())):
    cmd = list(input().rstrip())
    n = int(input())
    lst = input()

    parse_lst = []
    tmp = ""

    # 이 부분에서 코너케이스는, 배열이 없는 경우, 크기가 1인 경ㅑㄹ
    for i in lst:
        if i == ',' or i == ']':
            parse_lst.append(tmp)
            tmp = ""
        elif ord('9') >= ord(i) >= ord('0'):
            tmp += i

    index = [0, n]
    if n == 0:
        if 'D' in cmd:
            print('error')
            continue
        else:
            print('[]')
            continue
    if (a := cmd.count('D')) > len(parse_lst):
        print('error')
        continue
    elif a == len(parse_lst):
        print('[]')
        continue

    flag = 0

    for c in cmd:
        if c == 'R':
            if flag == 0:
                flag = 1
            else:
                flag = 0
        elif c == 'D':
            if flag == 0:
                index[flag] += 1
            else:
                index[flag] -= 1

        # 배열이 0인 경우, 코너케이스 아직 안함
    if index[0] < index[1]:
        if flag == 0:
            print('[', end='')
            for i in range(index[0], index[1]-1):
                print(parse_lst[i], end=',')
            print(f"{parse_lst[index[1]-1]}]")
        else:
            print('[', end='')
            for i in range(index[1]-1, index[0], -1):
                print(parse_lst[i], end=',')
            print(f"{parse_lst[index[0]]}]")
