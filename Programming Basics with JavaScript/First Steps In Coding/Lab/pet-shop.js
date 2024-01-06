function petShop(input) {
    let dogFoodCount = input[0];
    let catFoodCount = input[1];

    let dogFoodPrice = dogFoodCount * 2.50;
    let catFoodPrice = catFoodCount * 4;

    let totalSum = dogFoodPrice + catFoodPrice;

    console.log(`${totalSum} lv.`)
}

petShop(["5 ",
"4 "]);