function basketballEquioment(input) {
    let yearTax = Number(input[0]);

    let sneakersPrice = yearTax - (yearTax * 0.4);
    let outfit = sneakersPrice - (sneakersPrice * 0.2);
    let ball = outfit * 0.25;
    let equipment = ball * 0.2;

    let totalSum = sneakersPrice + outfit + ball + equipment + yearTax;

    console.log(totalSum);
}

basketballEquioment(["365 "]);