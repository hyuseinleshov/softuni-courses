// Person Info
function solve(firstName, lastName, age) {
    const person = {
        firstName: firstName,
        lastName: lastName,
        age: age
    };

    return person;
}

console.log(solve("Peter", "Pan", "20"));   // Expected Output:
// { firstName: 'Peter', lastName: 'Pan', age: '20' }

console.log(solve("George", "Smith", "18")); // Expected Output:
// { firstName: 'George', lastName: 'Smith', age: '18' }
