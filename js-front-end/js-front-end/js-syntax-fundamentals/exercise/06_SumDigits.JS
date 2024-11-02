function solve(num) {
    let numAsString = num.toString();
    let sum = 0;

    for (let i = 0; i < numAsString.length; i++) {
        sum += Number(numAsString.charAt(i));
    }

    console.log(sum);
}

solve(245678);	// 32
solve(97561);	// 28
solve(543);	    // 12