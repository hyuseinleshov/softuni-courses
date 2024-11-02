function solve(num) {
    const numAsString = num.toString();
    let sum = 0;
    let areTheSame = true;

    for (let i = 0; i < numAsString.length; i++) {
        if (numAsString[i] != numAsString[i + 1] && i < numAsString.length - 1) {
            areTheSame = false;
        }

        sum += Number(numAsString.charAt(i));
    }

    console.log(areTheSame);
    console.log(sum);
}

solve(2222222);	// true
                // 14
solve(1234);    // false
                // 10