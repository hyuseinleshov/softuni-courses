// Number Modification
function solve(num) {
    num = num.toString();
    let sum = num.split('')
        .reduce((sum, digit) => 
            sum += parseInt(digit), 0);
    let average = sum / num.length;

    if (average < 5) {
        while (average <= 5) {
            sum += 9;
            num += 9;
            average = sum / num.length;
        }
    }
    console.log(num);
}

solve(101);   // 1019999
solve(5835);  // 5835