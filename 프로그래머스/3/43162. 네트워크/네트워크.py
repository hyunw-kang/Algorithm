def solution(n, computers):

    visited = []
    for i in range(n):
        visited.append(False)

    def dfs(now):
        visited[now] = True
        for next_computer in range(n):
            if computers[now][next_computer] == 1 and visited[next_computer] == False:
                dfs(next_computer)

    count = 0
    for i in range(n):
        if visited[i] == False:
            dfs(i)
            count = count + 1
    return count