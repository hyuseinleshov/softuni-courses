// Palindrome Integers
function solve(numbers) {
    for (let number of numbers) {
        let reversed = number.toString().split('').reverse().join('');
        console.log(number == reversed ? 'true' : 'false');
    }
}

solve([123, 323, 421, 121]);  // Expected Output: false true false true
solve([32, 2, 232, 1010]);    // Expected Output: false true true false