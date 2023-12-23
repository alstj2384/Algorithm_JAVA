from collections import deque
import sys

input = sys.stdin.readline

queue = deque()
n = int(input())

for i in range(n):
    cmd = input().split()

    if len(cmd) > 1:
        if cmd[0] == "push_back":
            queue.append(int(cmd[1]))
        elif cmd[0] == "push_front":
            queue.appendleft(int(cmd[1]))
    elif cmd[0] == "front":
        if len(queue) != 0:
            print(queue[0])
        else:
            print(-1)
    elif cmd[0] == "back":
        if len(queue) != 0:
            print(queue[len(queue)-1])
        else:
            print(-1)
    elif cmd[0] == "pop_front":
        if len(queue) != 0:
            print(queue.popleft())
        else :
            print(-1)
    elif cmd[0] == "pop_back":
        if len(queue) != 0:
            print(queue.pop())
        else:
            print(-1)
    elif cmd[0] == "size":
        print(len(queue))
    elif cmd[0] == "empty":
        if len(queue) == 0 :
            print(1)
        else:
            print(0)
