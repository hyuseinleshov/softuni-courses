function solve(typeOfFruit, weightInGrams, pricePerKilogram) {
    let weightInKilograms = weightInGrams / 1000;
    let price = weightInKilograms * pricePerKilogram;

    console.log(`I need $${price.toFixed(2)} to buy ${weightInKilograms.toFixed(2)} kilograms ${typeOfFruit}.`);
}

solve('orange', 2500, 1.80); // I need $4.50 to buy 2.50 kilograms orange.
solve('apple', 1563, 2.35);  // I need $3.67 to buy 1.56 kilograms apple.