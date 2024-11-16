// Employees
function solve(array) {
    class Employee {
        constructor(name, personalNumber) {
            this.name = name;
            this.personalNumber = personalNumber;
        }
    }

    let employees = [];
    for (const string of array) {
        employees.push(new Employee(string, string.length));
    }

    employees.forEach(employee => console.log(`Name: ${employee.name} -- Personal Number: ${employee.personalNumber}`))
}

solve(["Silas Butler", "Adnaan Buckley", "Juan Peterson", "Brendan Villarreal"]); 
// Expected Output:
// Name: Silas Butler -- Personal Number: 12
// Name: Adnaan Buckley -- Personal Number: 14
// Name: Juan Peterson -- Personal Number: 13
// Name: Brendan Villarreal -- Personal Number: 18
