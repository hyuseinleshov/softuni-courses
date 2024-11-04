// Sum First and Last Array Elements
function solve(numbers) {
    let firstNum = numbers[0];
    let lastNum = numbers[numbers.length - 1];
    console.log(firstNum + lastNum);
}

solve([20, 30, 40]);	  // 60
solve([10, 17, 22, 33]);  // 43
solve([11, 58, 69]);	  // 80