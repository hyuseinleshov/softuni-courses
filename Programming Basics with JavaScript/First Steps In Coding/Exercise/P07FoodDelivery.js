function foodDelivery(input) {
    let chickenMenu = Number(input[0]);
    let fishMenu = Number(input[1]);
    let vegetarianMenu = Number(input[2]);

    let chickenMenuPrice = chickenMenu * 10.35;
    let fishMenuPrice = fishMenu * 12.40;
    let vegetarianMenuPrice = vegetarianMenu * 8.15;

    let totalSumForDishes = chickenMenuPrice + fishMenuPrice + vegetarianMenuPrice;

    let desertsSum = totalSumForDishes * 0.2;
    let totalSum = totalSumForDishes + desertsSum + 2.50;

    console.log(totalSum);
}

foodDelivery(["2 ", "4 ", "3 "]);