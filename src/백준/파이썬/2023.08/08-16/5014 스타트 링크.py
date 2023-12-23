from collections import deque
f, s, g, u, d = map(int, input().split())

visited = [0] * (f+1)
result = []
def bfs(s, c):
    queue = deque()
    queue.append((s, c))
    while queue:
        n, c = queue.popleft()
        if n == g:
            result.append(c)
            return
        for i in [u, -d]:
            k = n + i
            if k > f or k < 1:
                continue
            if visited[k] == 0:
                visited[k] = True
                queue.append((k, c+1))

bfs(s, 0)

if result:
    print(min(result))
else:
    print("use the stairs")


"""
제출 기록 (누적 문제 풀이 시간 - 제출 결과)
33분 - 실패 (s == g인 경우를 고려하지 못함)
35분 - 성공 
"""
