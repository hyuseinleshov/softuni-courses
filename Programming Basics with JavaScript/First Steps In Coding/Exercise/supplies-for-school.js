function suppliesForSchool(input) {
    let pensCount = Number(input[0]);
    let markersCount = Number(input[1]);
    let litersCleaningDetergent = Number(input[2]);
    let percentDiscount = Number(input[3]);

    let pensPrice = pensCount * 5.80;
    let markersPrice = markersCount * 7.20;
    let detergentPrice = litersCleaningDetergent * 1.20;

    let sum = pensPrice + markersPrice + detergentPrice;

    let sumWithDiscount = sum - (sum * (percentDiscount / 100));

    console.log(sumWithDiscount);
}

suppliesForSchool(["2 ", "3 ", "4 ", "25 "]);