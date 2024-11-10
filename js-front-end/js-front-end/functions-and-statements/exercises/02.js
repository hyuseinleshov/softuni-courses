// Add and Subtract
function solve(num1, num2, num3) {
    function sum(num1, num2) {
        return num1 + num2;
    }
    
    function subtract(sumResult, num3) {
        return sumResult - num3;
    }

    return subtract(sum(num1, num2), num3);
}

console.log(solve(23, 6, 10)); // Expected Output: 19
console.log(solve(1, 17, 30)); // Expected Output: -12
console.log(solve(42, 58, 100)); // Expected Output: 0