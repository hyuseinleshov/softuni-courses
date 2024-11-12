// Address Book
function solve(input) {
    let addresses = {};

    for (let line of input) {
        let tokens = line.split(':');
        let name = tokens[0];
        let address = tokens[1];

        addresses[name] = address;
    }

    let sorted = Object.entries(addresses);
    sorted.sort((a, b) => a[0].localeCompare(b[0]));

    for (let [key, value] of sorted) {
        console.log(`${key} -> ${value}`);
    }
}

solve([
    "Tim:Doe Crossing",
    "Bill:Nelson Place",
    "Peter:Carlyle Ave",
    "Bill:Ornery Rd"
]);
// Expected Output:
// Bill -> Ornery Rd
// Peter -> Carlyle Ave
// Tim -> Doe Crossing

solve([
    "Bob:Huxley Rd",
    "John:Milwaukee Crossing",
    "Peter:Fordem Ave",
    "Bob:Redwing Ave",
    "George:Mesta Crossing",
    "Ted:Gateway Way",
    "Bill:Gateway Way",
    "John:Grover Rd",
    "Peter:Huxley Rd",
    "Jeff:Gateway Way",
    "Jeff:Huxley Rd"
]);
// Expected Output:
// Bill -> Gateway Way
// Bob -> Redwing Ave
// George -> Mesta Crossing
// Jeff -> Huxley Rd
// John -> Grover Rd
// Peter -> Huxley Rd
// Ted -> Gateway Way
