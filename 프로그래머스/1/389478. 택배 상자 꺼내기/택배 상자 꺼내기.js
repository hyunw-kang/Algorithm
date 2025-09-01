function solution(n, w, num) {
    var answer = 0;
    
    let len = Math.ceil(n / w)
    let boxArr = Array.from({length : len}, () => []);
    let pos = {};
    let box = 1;
    
    for(let i = 0; i < len; i++){
        let col = 0;
        for(let j = 0; j < w; j++){
            if(i %2 == 0){
                if(box > n){
                    boxArr[i].push(0);
                } else{
                    boxArr[i].push(box);
                }
                col++;
            } else {
                if (box > n){
                    boxArr[i].unshift(0);
                } else{
                    boxArr[i].unshift(box);
                }
                col--;
            }
            if(box == num){
                pos.row = i;
                if( i % 2 == 0){
                    pos.col = col - 1;
                } else{
                    pos.col = w + col;
                }
            }
            box++;
        }
    }
    let count = 0;
    for(let i = pos.row; i < boxArr.length;i++){
        if(boxArr[i][pos.col]) count++;
    }
    return count;
}
console.log(solution(22,6,8))