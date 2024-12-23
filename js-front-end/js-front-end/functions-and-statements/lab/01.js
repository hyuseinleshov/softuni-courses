// Format Grade
function solve(grade) {
    if (grade < 3.00) {
        console.log('Fail (2)');
    } else if (grade < 3.50) {
        console.log(`Poor (${grade.toFixed(2)})`);
    } else if (grade < 4.50) {
        console.log(`Good (${grade.toFixed(2)})`);
    } else if (grade < 5.50) {
        console.log(`Very good (${grade.toFixed(2)})`);
    } else {
        console.log(`Excellent (${grade.toFixed(2)})`);
    }
}

solve(3.33); // Expected Output: Poor (3.33)
solve(4.50); // Expected Output: Very good (4.50)
solve(2.99); // Expected Output: Fail (2)