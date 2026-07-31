def puzzle(diffs, times, limit, level):
    clear = 0
    for i in range (len(diffs)):
        if diffs[i] <= level : clear += times[i]
        if diffs[i] > level : clear += (diffs[i]-level)*(times[i-1]+times[i])+times[i]
        if clear > limit: return False
    return True
 
def solution(diffs, times, limit):
    start, mid, end = 1,0,max(diffs)
 
    while start<=end:
        mid = (start+end)//2
        
        if puzzle(diffs, times, limit, mid): end = mid-1
        else: start = mid+1
    
    ## start : 1, mid : 1, end : 2 인 경우
    if puzzle(diffs, times, limit, mid): return mid
    if puzzle(diffs, times, limit, mid+1): return mid+1
    return mid-1