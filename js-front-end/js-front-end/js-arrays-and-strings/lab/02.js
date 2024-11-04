// Reverse an Array of Numbers
function solve(n, numbers) {
    let partOfNumbers = numbers.slice(0, n);
    partOfNumbers.reverse();
    console.log(partOfNumbers.join(' '));
}

solve(3, [10, 20, 30, 40, 50]);	 // 30 20 10
solve(4, [-1, 20, 99, 5]);	     // 5 99 20 -1
solve(2, [66, 43, 75, 89, 47]);	 // 43 66