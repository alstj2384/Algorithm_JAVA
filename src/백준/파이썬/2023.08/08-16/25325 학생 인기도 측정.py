n = int(input())

names = {}


for i in list(input().split()):
    names[i] = 0

for i in range(n):
    for name in list(input().split()):
        if name in names:
            names[name] += 1
        else:
            names[name] = 1

names = sorted(names.items(), reverse = True, key = lambda x : x[1])

for i in names:
    print(f"{i[0]} {i[1]}")

"""
제출 기록 (누적 문제 풀이 시간 - 제출 결과)
8분 - 실패 (사전순 정렬을 거꾸로함)
11분 - 성공
"""