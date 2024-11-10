// Odd and Even Sum
function solve(number) {
    const numbers = number.toString().split('').map(char => Number(char));
    let evenSum = 0, oddSum = 0;

    for (let number of numbers) {
        if (number % 2 == 0) {
            evenSum += number;
        } else {
            oddSum += number;
        }
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

solve(1000435);        // Expected Output: Odd sum = 9, Even sum = 4
solve(3495892137259234); // Expected Output: Odd sum = 54, Even sum = 22