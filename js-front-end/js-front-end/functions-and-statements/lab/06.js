// Sign Check
function solve(numOne, numTwo, numThree) {
    if (numOne < 0 && numTwo > 0 && numThree > 0) {
        console.log('Negative');
    } else if (numOne > 0 && numTwo < 0 && numThree > 0) {
        console.log('Negative');
    } else if (numOne > 0 && numTwo > 0 && numThree < 0) {
        console.log('Negative');
    } else if (numOne < 0 && numTwo < 0 && numThree < 0) {
        console.log('Negative');
    } else {
        console.log('Positive');
    }
}

solve(5, 12, -15);       // Expected Output: Negative
solve(-6, -12, 14);      // Expected Output: Positive
solve(-1, -2, -3);       // Expected Output: Negative
solve(-5, 1, 1);         // Expected Output: Negative