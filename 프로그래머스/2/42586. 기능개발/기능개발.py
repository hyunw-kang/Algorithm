def solution(progresses, speeds):
    days = []
    n = len(progresses)
    for i in range(n):
        left = 100 - progresses[i]
        remain = left // speeds[i]
        if left % speeds[i] != 0:
            remain = remain + 1
        days.append(remain)
        
        
    answer = []
    cur = days[0]
    count = 1
    for i in range(1, len(days)):
        if days[i] <= cur:
            count = count+1
        else:
            answer.append(count)
            cur = days[i]
            count = 1
    answer.append(count)
    return answer