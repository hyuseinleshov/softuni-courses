function yardGreening(input) {
    let squareMeters = input[0];
    let sum = squareMeters * 7.61;
    let discount = sum * 0.18;
    let sumWithDiscount = sum - discount;

    console.log(`The final price is: ${sumWithDiscount} lv.`)
    console.log(`The discount is: ${discount} lv.`)
}

yardGreening(["550"]);