function solve(year) {
    let result;

    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        result = 'yes';
    } else {
        result = 'no';
    }

    console.log(result);
}

solve(1984);	// yes
solve(2003);	// no
solve(4);       // yes
solve(2000)     // yes