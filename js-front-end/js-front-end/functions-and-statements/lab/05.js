// Simple Calculator
function solve (numOne, numTwo, operator) {
    switch (operator) {
        case 'multiply':
            multiply(numOne, numTwo);
            break;
        case 'divide':
            divide(numOne, numTwo);
            break;
        case 'add':
            add(numOne, numTwo);
            break;
        case 'subtract':
            subtract(numOne, numTwo);
            break;
    }

    function multiply(numOne, numTwo) {
        console.log(numOne * numTwo);
    }

    function divide(numOne, numTwo) {
        console.log(numOne / numTwo);
    }

    function add(numOne, numTwo) {
        console.log(numOne + numTwo);
    }

    function subtract(numOne, numTwo) {
        console.log(numOne - numTwo);
    }
}

solve(5, 5, 'multiply');       // Expected Output: 25
solve(40, 8, 'divide');        // Expected Output: 5
solve(12, 19, 'add');          // Expected Output: 31
solve(50, 13, 'subtract');     // Expected Output: 37