def solution(prices):
    n = len(prices)
    answer = []
    
    for i in range(n):
        count = 0
        for j in range(i+1, n):
            count = count + 1
            if prices[i] > prices[j]:
                break
        answer.append(count)
    return answer