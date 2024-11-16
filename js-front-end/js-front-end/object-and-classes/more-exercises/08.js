// Garage
function solve(array) {
    const garages = new Map();

    for (const string of array) {
        let [garageNumber, carInfo] = string.split(" - ");
        carInfo = carInfo.split(", ");

        let car = [];
        for (const info of carInfo) {
            const [key, value] = info.split(": ");
            car.push(`${key} - ${value}`);
        }
        car = car.join(", ");
        
        if (!garages.has(garageNumber)) {
            garages.set(garageNumber, []);
        }

        garages.get(garageNumber).push(car);
    }

    for (const [key, value] of garages) {
        console.log("Garage № " + key);

        value.forEach(car => {
            console.log("--- " + car);
        });
    }
}

solve([
    "1 - color: blue, fuel type: diesel",
    "1 - color: red, manufacture: Audi",
    "2 - fuel type: petrol",
    "4 - color: dark blue, fuel type: diesel, manufacture: Fiat"
]);
// Expected Output:
// Garage № 1
// --- color - blue, fuel type - diesel
// --- color - red, manufacture - Audi
// Garage № 2
// --- fuel type - petrol
// Garage № 4
// --- color - dark blue, fuel type - diesel, manufacture - Fiat
