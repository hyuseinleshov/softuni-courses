// Phone Book
function solve(array) {
    let phoneBook = {};

    for (let string of array) {
        const data = string.split(' ');
        const name = data[0];
        const number = data[1];

        phoneBook[name] = number;
    }

    for (let key in phoneBook) {
        console.log(`${key} -> ${phoneBook[key]}`);
    }
}

solve([
    "Tim 0834212554",
    "Peter 0877547887",
    "Bill 0896543112",
    "Tim 0876566344"
]); 
// Expected Output:
// Tim -> 0876566344
// Peter -> 0877547887
// Bill -> 0896543112

solve([
    "George 0552554",
    "Peter 087587",
    "George 0453112",
    "Bill 0845344"
]);
// Expected Output:
// George -> 0453112
// Peter -> 087587
// Bill -> 0845344
