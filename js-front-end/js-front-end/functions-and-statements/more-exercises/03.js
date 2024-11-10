// Points Validation
function solve(numbers) {
    const x1 = numbers[0];
    const y1 = numbers[1];
    const x2 = numbers[2];
    const y2 = numbers[3];

    function calculateDistance(x1, y1, x2, y2) {
        return Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2);
    }

    console.log(`{${x1}, ${y1}} to {0, 0} is ${
        Number. isInteger(calculateDistance(numbers[0], numbers[1], 0, 0)) ? 'valid' : 'invalid'
    }`);
    console.log(`{${x2}, ${y2}} to {0, 0} is ${
        Number. isInteger(calculateDistance(numbers[2], numbers[3], 0, 0)) ? 'valid' : 'invalid'
    }`);
    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${
        Number. isInteger(calculateDistance(numbers[0], numbers[1], numbers[2], numbers[3])) ? 'valid' : 'invalid'
    }`);
}

solve([3, 0, 0, 4]);
// {3, 0} to {0, 0} is valid
// {0, 4} to {0, 0} is valid
// {3, 0} to {0, 4} is valid
solve([2, 1, 1, 1]);
// {2, 1} to {0, 0} is invalid
// {1, 1} to {0, 0} is invalid
// {2, 1} to {1, 1} is valid