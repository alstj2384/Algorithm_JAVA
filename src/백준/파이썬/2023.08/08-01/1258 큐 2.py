from collections import deque
import sys

input = sys.stdin.readline

queue = deque()

for _ in range(int(input())):
    cmd = input().split()

    if cmd[0] == 'push':
        queue.append(cmd[1])
    elif cmd[0] == 'pop':
        if not queue:
            print('-1')
            continue
        print(queue.popleft())
    elif cmd[0] == 'size':
        print(len(queue))
    elif cmd[0] == 'empty':
        print(0) if queue else print(1)
    elif cmd[0] == 'front':
        if not queue:
            print('-1')
            continue
        print(queue[0])
    elif cmd[0] == 'back':
        if not queue:
            print('-1')
            continue
        print(queue[-1])