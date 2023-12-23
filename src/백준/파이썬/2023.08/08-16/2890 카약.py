n , m = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(input().rstrip()))

rank = []
for i in graph:
    count = 0
    for j in i:
        if j == 'S' or j == 'F':
            continue
        elif j == '.':
            count += 1
        else:
            rank.append((count, int(j))) # 길이, 라인 번호
            break

rank = sorted(rank,reverse = True)

count = 1
idx = [0] * 10

for i in range(1, len(rank)):
    now = rank[i][0]
    prev = rank[i-1][0]

    if prev != now:
        idx[rank[i-1][1]] = count
        count += 1
    else:
        idx[rank[i-1][1]] = count

idx[rank[8][1]] = count
for i in range(1, 10):
    print(idx[i])