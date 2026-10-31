def solution(numbers, target):
    def dfs(idx,sum):
        if idx == len(numbers):
            if sum == target:
                return 1
            return 0
        return dfs(idx + 1, sum + numbers[idx]) + dfs(idx + 1, sum - numbers[idx])
    return dfs(0, 0)