import sys
input = sys.stdin.readline

stack = []
n = int(input())
index = 1
print_list = ''

# 입력받은 array를 순회하기
for j in range(n):
    num = int(input())

    while index <= num:
        stack.append(index)
        index += 1
        print_list += '+\n'

    if stack[-1] == num:
        stack.pop()
        print_list += '-\n'

    else:
        print_list = 'NO'
        break

print(print_list)

