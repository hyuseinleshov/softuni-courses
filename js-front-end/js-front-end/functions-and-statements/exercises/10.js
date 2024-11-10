// Factorial Division
function solve(num1, num2) {

    function factorialize(num) {
        if (num < 0) {
            return -1;
        } else if (num == 0) {
            return 1;
        } else {
            return (num * factorialize(num - 1));
        }
    }

    console.log((factorialize(num1) / factorialize(num2)).toFixed(2));
}

solve(5, 2);   // Expected Output: 60.00
solve(6, 2);   // Expected Output: 360.00