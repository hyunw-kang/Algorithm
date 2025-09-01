function solution(num_list, n) {
    var answer = [];
    
    for(let i = 0; i < n; i++){
        answer.push(num_list[i])
    }
    //return num_list.slice(0,n);
    //answer = num_list.splice(0,n);
    return answer;
}