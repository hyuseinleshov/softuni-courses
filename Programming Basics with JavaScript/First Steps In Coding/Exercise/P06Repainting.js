function repainting(input) {
    let neededNylon = Number(input[0]);
    let neededPaint = Number(input[1]);
    let thinner = Number(input[2]);
    let hours = Number(input[3]);

    let nylonPrice = (neededNylon + 2) * 1.50;
    let paintPrice = (neededPaint + (neededPaint * 0.1)) * 14.50;
    let thinnerPrice = thinner * 5.00;

    let sum = nylonPrice + paintPrice + thinnerPrice + 0.40;
    let workersSum = (sum * 0.3) * hours;
    let totalSum = sum + workersSum;

    console.log(totalSum);
}

repainting(["10 ", "11 ", "4 ", "8 "]);