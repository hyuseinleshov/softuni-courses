// Math Power
function solve(number, power) {
    let result = 1;

    for (let i = 0; i < power; i++) {
        result *= number;
    }

    console.log(result);
}

solve(2, 8); // Expected Output: 256
solve(3, 4); // Expected Output: 81