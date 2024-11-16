// Catalogue
function solve(array) {
    let products = {};

    for (const string of array) {
        let[name, price] = string.split(' : ');
        price = Number(price);
        products[name] = price;
    }

    const sortedProducts = Object.entries(products)
        .sort(([keyA], [keyB]) => keyA.localeCompare(keyB));

    let currentLetter = '';

    for (const[key, value] of sortedProducts) {
        if (key.charAt(0) !== currentLetter) {
            currentLetter = key.charAt(0);
            console.log(currentLetter);
        }

        console.log(`  ${key}: ${value}`)
    }
}

solve([
    'Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
]);
// Expected Output:
// A
//   Anti-Bug Spray: 15
//   Apple: 1.25
//   Appricot: 20.4
// B
//   Boiler: 300
// D
//   Deodorant: 10
// F
//   Fridge: 1500
// T
//   T-Shirt: 10
//   TV: 1499
