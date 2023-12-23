# 몇행 몇열인지 입력받고, 크기상에서 어느 사분면에 위치하는 지 확인한다
# 4사분면이라면 그 전까지의 개수를 모두 더하고 일단, 전체 크기 * 3/4
# 그 위치에서 또 재귀적으로 ..

# 재귀함수에 들어가는 것은, 탐색 행과 열, 줄여진 배열의 크기정보
# 탈출조건 : 행의 크기가 2가 됐을 때..
# 그렇다면 행과 열에 대한 판단을 위한 조건이 필요함

n, r, c = map(int, input().split())

s = 2 ** n


def recursive(r, c, size):
    area = size**2 // 4
    if (r >= 0 and r <= size//2-1) and (c >= 0 and c <= size//2-1): # 1사분면
        if size == 2:
            return 0
        else:
            return (area * 0) + recursive(r, c, size//2)
    elif (r >= 0 and r <= size//2-1) and (c >= size//2 and c <= size - 1): # 2사분면
        if size == 2:
            return 1
        else:
            return (area * 1) + recursive(r, c-(size//2), size//2)
    elif (r >= size//2 and r <= size - 1) and (c >= 0 and c <= size // 2 - 1):  # 3사분면
        if size == 2:
            return 2
        else:
            return (area * 2) + recursive(r-(size//2), c, size//2)
    elif (r >= size//2 and r <= size - 1) and (c >= size//2 and c <= size - 1):  # 4사분면
        if size == 2:
            return 3
        else:
            return (area * 3) + recursive(r-(size//2), c-(size//2), size//2)

print(recursive(r, c, s))