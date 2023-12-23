form = list(input().split('-'))

tmp_form = []

for item in form:
    tmp = list(map(int, item.split('+')))
    ans = sum(tmp)
    tmp_form.append(ans)

result = tmp_form[0]
for i in range(len(tmp_form)):
    if i != 0:
        result -= tmp_form[i]

print(result)