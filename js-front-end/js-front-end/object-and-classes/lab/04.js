// Convert to JSON
function solve(firstName, lastName, hairColor) {
    const person = {
        name: firstName,
        lastName: lastName,
        hairColor: hairColor
    };

    console.log(JSON.stringify(person));
}

solve("George", "Jones", "Brown");  
// Expected Output:
// {"name":"George","lastName":"Jones","hairColor":"Brown"}

solve("Peter", "Smith", "Blond");   
// Expected Output:
// {"name":"Peter","lastName":"Smith","hairColor":"Blond"}
