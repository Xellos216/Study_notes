n = int(input())
# 도시의 수를 입력받아 정수로 저장 (예: 4)

distance = list(map(int, input().split()))
# 각 도시 사이의 거리(n-1개)를 공백 기준으로 입력받아 리스트로 변환
# 예: "2 3 1" -> [2, 3, 1]

price = list(map(int, input().split()))
# 각 도시의 리터당 주유 가격(n개)를 입력받아 리스트로 저장
# 예: "5 2 4 1" -> [5, 2, 4, 1]

total = 0
# 전체 주유 비용을 누적할 변수

min_price = price[0]
# 출발 도시에서의 주유 가격으로 초기화
# 앞으로 갈수록 더 싼 주유소가 나타나면 이 값을 갱신함

for i in range(n - 1):
# 마지막 도시는 도착지이므로 주유 필요 없음 -> 총 거리만큼 반복

    if price[i] < min_price:
       min_price = price[i]
       # 현재 도시의 주유 가격이 지금까지 중 가장 싸다면 min_price를 갱신

    total += min_price * distance[i]
    # 현재 도시에서 다음 도시까지 이동할 거리만큼, 가장 싼 가격으로 주유

print(total)
# 최소 주유 비용 출력
