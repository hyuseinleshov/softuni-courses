function solve(groupOfPeople, typeOfTheGroup, dayOfTheWeek) {
    let price;

    switch (typeOfTheGroup) {
        case 'Students':
            if (dayOfTheWeek == 'Friday') {
                price = groupOfPeople * 8.45;
            } else if (dayOfTheWeek == 'Saturday') {
                price = groupOfPeople * 9.80;
            } else if (dayOfTheWeek == 'Sunday') {
                price = groupOfPeople * 10.46;
            }

            if (groupOfPeople >= 30) {
                price -= price * 0.15;
            }
            break;
        case 'Business':
            if (groupOfPeople >= 100) {
                groupOfPeople -= 10;
            }

            if (dayOfTheWeek == 'Friday') {
                price = groupOfPeople * 10.90;
            } else if (dayOfTheWeek == 'Saturday') {
                price = groupOfPeople * 15.60;
            } else if (dayOfTheWeek == 'Sunday') {
                price = groupOfPeople * 16;
            }
            break;
        case 'Regular':
            if (dayOfTheWeek == 'Friday') {
                price = groupOfPeople * 15;
            } else if (dayOfTheWeek == 'Saturday') {
                price = groupOfPeople * 20;
            } else if (dayOfTheWeek == 'Sunday') {
                price = groupOfPeople * 22.50;
            }

            if (groupOfPeople >= 10 && groupOfPeople <= 20) {
                price -= price * 0.05;
            }
            break;
    }

    console.log(`Total price: ${price.toFixed(2)}`)
}

solve(30, "Students", "Sunday");    // Total price: 266.73
solve(40, "Regular", "Saturday");   // Total price: 800.00