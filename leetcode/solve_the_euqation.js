var solveEquation = function(equation) {
    var equations = equation.split('=');
    function find(equ) {
        var isPlus = true;
        var numStr = '';
        var d = {0: 0,1:0};
        for (var i = 0; i < equ.length; i += 1) {
            if (equ[i] === '-' || equ[i] === '+') {
                if (numStr !== '') {
                    d[1] = d[1] + +numStr;
                    numStr = '';
                }
            } else if (equ[i] === 'x') {
                var num = 0;
                if (numStr === '+' || numStr === '') {
                    num = 1;
                } else if(numStr === '-'){
                    num = -1;
                } else {
                    num = +numStr;
                }
                numStr = '';
                d[0] += num;
                continue;
            }
            numStr += equ[i];
        }
        if (numStr !== '') {
            d[1] += +numStr;
        }
        return d;
    }
    var v1 = find(equations[0]), v2 = find(equations[1]);
    if (v1[0] === v2[0] && v1[1] === v2[1]) {
        return 'Infinite solutions';
    } else if (v1[0] === v2[0]) {
        return "No solution";
    }
    var a = v1[0] - v2[0];
    var b = (v1[1] - v2[1]) * -1;
    return 'x=' + (b / a);
};
