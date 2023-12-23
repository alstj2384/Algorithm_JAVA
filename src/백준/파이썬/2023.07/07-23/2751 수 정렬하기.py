import sys
input = sys.stdin.readline

n = int(input())

graph = []
for i in range(n):
    graph.append(int(input()))

graph = sorted(graph)

for i in graph:
    print(i)