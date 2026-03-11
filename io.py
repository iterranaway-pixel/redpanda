a = [16, 17, 5, 10, 4, 3, 1, 5]
b = []
n = len(a)

for i in range(n):
    mx = float('-inf')
    for j in range(i + 1, n):
        mx = max(mx, a[j])
    if a[i] > mx:
        b.append(a[i])

print(b)
