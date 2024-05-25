function fishTank(input) {
    let length = Number(input[0]);
    let width = Number(input[1]);
    let height = Number(input[2]);
    let percent = Number(input[3]);

    let fishTankVolume = length * width * height;
    let volumeInLitres = fishTankVolume / 1000;
    let engagedSpace = percent / 100;

    let neededLitres = volumeInLitres * (1 - engagedSpace);

    console.log(neededLitres);
}

fishTank(["85 ", "75 ", "47 ", "17 "]);