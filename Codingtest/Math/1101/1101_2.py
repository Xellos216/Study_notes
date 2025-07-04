import math # sqrt 함수를 사용하기 위해 math 모듈 임포트

# 테스트 케이스 수 입력
T = int(input())

# 각 테스트 케이스마다 반복
for _ in range(T):
    # 현재 위치 x, 목표 위치 y 입력
    x, y = map(int, input().split())
    d = y - x # 총 이동 거리 계산

    # n은 d의 제곱근에 가장 가까운 정수 (n^2 <= d < (n+1)^2 만족하는 n)
    n = int(math.sqrt(d))

    # 규칙 1: d가 n^2와 같으면 -> 이동 횟수는 2n - 1
    if d == n ** 2:
       print(2 * n - 1)

    # 규칙 2: d 가 n^2보단 크고 n(n+1)보다 작거나 같으면 -> 이동 횟수는 2n
    elif d <= n * (n + 1):
        print(2 * n)

    # 규칙 3: d가 n(n+1)보다 크면 -> 이동 횟수는 2n + 1
    else:
        print(2 * n + 1)

