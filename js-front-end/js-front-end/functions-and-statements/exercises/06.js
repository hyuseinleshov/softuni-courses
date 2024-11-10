// Password Validator
function solve(password) {
    const lengthRegex = /^.{6,10}$/;
    const lettersAndDigitsRegex = /^[a-zA-Z0-9]+$/;
    const atLeastTwoDigitsRegex = /(.*[0-9].*[0-9])/;

    if (!lengthRegex.test(password)) {
        console.log('Password must be between 6 and 10 characters');
    }

    if (!lettersAndDigitsRegex.test(password)) {
        console.log('Password must consist only of letters and digits');
    }

    if (!atLeastTwoDigitsRegex.test(password)) {
        console.log('Password must have at least 2 digits');
    }

    if (
        lengthRegex.test(password) &&
        lettersAndDigitsRegex.test(password) &&
        atLeastTwoDigitsRegex.test(password)
    ) {
        console.log('Password is valid');
    }
}

solve("logIn");    // Expected Output:
                   // Password must be between 6 and 10 characters
                   // Password must have at least 2 digits
solve("MyPass123"); // Expected Output: Password is valid
solve("Pa$s$s");    // Expected Output:
                   // Password must consist only of letters and digits
                   // Password must have at least 2 digits