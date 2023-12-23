from collections import deque

n, k = map(int, input().split())


visited = [0] * 100001


def bfs(n):
    queue = deque()
    queue.append((n, 0))
    while queue:
        n, c = queue.popleft()
        if n == k:
            return c
        visited[n] = True
        for step in [n * 2, n + 1, n -1]:
            if 0 <= step <= 100000 and not visited[step]:
                if step == n * 2:
                    queue.appendleft((step, c))
                else:
                    queue.append((step, c + 1))
                visited[step] = True


print(bfs(n))