expression = input()

parts = expression.split('-')
result = 0

# 첫 항은 더해줌
first_sum = sum(map(int, parts[0].split('+')))
result += first_sum

# 나머지 항들은 괄호로 묶인 것처럼 모두 빼기
for part in parts[1:]:
    result -= sum(map(int, part.split('+')))

print(result)
