function solve(typeOfDay, age) {
    let price;

    switch (typeOfDay) {
        case 'Weekday':
            if (age >= 0 && age <= 18) {
                price = 12;
            } else if (age > 18 && age <= 64) {
                price = 18;
            } else if (age > 64 && age <= 122) {
                price = 12;
            } else {
                price = -1;
            }
            
            break;
        case 'Weekend':
            if (age >= 0 && age <= 18) {
                price = 15;
            } else if (age > 18 && age <= 64) {
                price = 20;
            } else if (age > 64 && age <= 122) {
                price = 15;
            } else {
                price = -1;
            }

            break;
        case 'Holiday':
            if (age >= 0 && age <= 18) {
                price = 5;
            } else if (age > 18 && age <= 64) {
                price = 12;
            } else if (age > 64 && age <= 122) {
                price = 10;
            } else {
                price = -1;
            }

            break;
    }

    if (price == -1) {
        console.log('Error!')
    } else {
        console.log(price + '$')
    }
}

solve('Weekday', 42);