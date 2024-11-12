// Convert to Object
function solve(jsonStr) {
    let person = JSON.parse(jsonStr);

    let entries = Object.entries(person);
    for (let [key, value] of entries) {
        console.log(`${key}: ${value}`);
    }
}

solve('{"name": "George", "age": 40, "town": "Sofia"}');
// Expected Output:
// name: George
// age: 40
// town: Sofia

solve('{"name": "Peter", "age": 35, "town": "Plovdiv"}');
// Expected Output:
// name: Peter
// age: 35
// town: Plovdiv
