function solve(num, op1, op2, op3, op4, op5) {
    let currentOp;

    for (let i = 1; i <= 5; i++) {
        currentOp = eval('op' + i);

        switch (currentOp) {
            case 'chop':
                num /= 2;
                break;
            case 'dice':
                num = Math.sqrt(num);
                break;
            case 'spice':
                num++;
                break;
            case 'bake':
                num *= 3;
                break;
            case 'fillet':
                num -= num * 0.2;
                break;
        }

        console.log(num);
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
// 16
// 8
// 4
// 2
// 1

solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');
// 3
// 4
// 2
// 6
// 4.8