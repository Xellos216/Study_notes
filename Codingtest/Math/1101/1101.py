import math

T = int(input())
for _ in range(T):
    x, y = map(int, input().split())
    d = y - x
    n = int(math.sqrt(d)) # n^2 <= d< (n+1)^에서 n 찾기

    if d == n ** 2:
       print(2 * n - 1)
    elif d <= n * (n + 1):
       print(2 * n)
    else:
       print(2 * n + 1)
