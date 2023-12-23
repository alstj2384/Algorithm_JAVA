n,m,k = map(int, input().split())

data = list(map(int, input().split()))

data.sort() # 입력 데이터 정렬

first = data[n-1] # 리스트의 가장 큰 수를 저장
second = data[n-2] # 리스트의 두 번째로 큰 수를 저장

result = 0

while True:
    for i in range(k): # 가장 큰 수를 k번 더하기.
        if m == 0: # 반복마다 m이 0이 되면 탈출
            break
        result += first
        m -= 1

    if m == 0:
        break
    result += second # 두 번째로 큰 수를 더하기
    m -= 1

print(result)