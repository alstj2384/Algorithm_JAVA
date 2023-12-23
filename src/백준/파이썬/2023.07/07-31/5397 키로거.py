import sys
input = sys.stdin.readline

for _ in range(int(input())):
    password = list(input().rstrip())
    st1 = []
    st2 = []

    for i in password:
        if i == '<':
            if st1:
                st2.append(st1.pop())
        elif i == '>':
            if st2:
                st1.append(st2.pop())
        elif i == '-':
            if st1:
                st1.pop()
        else:
            st1.append(i)
    st1.extend(reversed(st2))
    print(''.join(st1))
