from collections import deque

n, m = map(int, input().split())

visited = [False] * 100001


def bfs(x, goal):
    queue = deque()

    queue.append((x, 0))

    while queue:
        v, p = queue.popleft()
        if v == goal:
            return p
        if v >= 0 and v <= 100000:
            if not visited[v]:
                queue.append((2*v, p+1))
                queue.append((v-1, p+1))
                queue.append((v+1, p+1))
                visited[v] = True


print(bfs(n, m))




