n = int(input())

table = []
for _ in range(n):
    table.append(list(map(int, input().split())))

blue = 0
white = 0


def check_elem(mat, k):
    a = mat[0][0]
    for i in range(k):
        for j in range(k):
            if mat[i][j] != a:
                return False
    return True


def choose_color(color):
    if color == 1:
        global blue
        blue += 1
    else:
        global white
        white += 1


def cut(mat, n):
    if check_elem(mat, n):
        choose_color(mat[0][0])
        return
    q = 0
    w = n//2
    for i in range(2):
        k = 0
        for j in range(2):
            sample_mat = [row[0+k:w+k] for row in mat[0+q:w+q]]
            if not check_elem(sample_mat, w):
                cut(sample_mat, w)
            else :
                choose_color(sample_mat[0][0])
            k += n // 2
        q += n // 2


cut(table, n)
print(white)
print(blue)
