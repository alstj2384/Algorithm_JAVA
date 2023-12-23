import sys
input = sys.stdin.readline

S = 0


for i in range(int(input())):
    n = input().split()

    if n[0] == "empty":
        S = 0
    elif n[0] == "all":
        S = (1 << 21) - 1
    else:
        op = n[0]
        num = int(n[1])

        if op == 'add':
            S |= (1 << num)
        if op == "remove":
            S &= ~(1 << num)
        if op == 'check':
            if S & (1 << num) == 0:
                print(0)
            else:
                print(1)
        if op == 'toggle':
            S = S ^ (1 << num)

