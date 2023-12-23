d = [0] * 81
d2 = [0] * 81

d[1], d[2] = 1, 1

n = int(input())

for i in range(3, n + 1):
    d[i] = d[i-1] + d[i-2]

d2[1] = 4

for i in range(2, n + 1):
    d2[i] = d[i]*2 + d2[i-1]

print(d2[n])

"""
제출 기록 (누적 문제 풀이 시간 - 제출 결과)
13분 - 성공
"""