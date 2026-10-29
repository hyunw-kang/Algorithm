def solution(progresses, speeds):
    n = len(progresses)

    days = []
    for i in range(n):
        remain = 100 - progresses[i]
        day = remain // speeds[i]
        if remain % speeds[i] != 0:
            day = day + 1
        days.append(day)

    answer = []
    cur = days[0]
    count = 1
    for i in range(1, n):
        if days[i] <= cur:
            count = count + 1
        else:
            answer.append(count)
            cur = days[i]
            count = 1
    answer.append(count)

    return answer