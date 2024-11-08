// Login
function solve(input) {
    let username = input.shift();
    let password = username.split('').reverse().join('');
    let counter = 0;

    for (let attempt of input) {
        if (attempt == password) {
            console.log(`User ${username} logged in.`);
            break;
        } else {
            counter++;
            if (counter == 4) {
                console.log(`User ${username} blocked!`);
                break;
            }

            console.log('Incorrect password. Try again.');
        }
    }
}

solve(['Acer', 'login', 'go', 'let me in', 'recA']); 
// Expected Output:
// Incorrect password. Try again.
// Incorrect password. Try again.
// Incorrect password. Try again.
// User Acer logged in.

solve(['momo', 'omom']); 
// Expected Output:
// User momo logged in.

solve(['sunny', 'rainy', 'cloudy', 'sunny', 'not sunny']); 
// Expected Output:
// Incorrect password. Try again.
// Incorrect password. Try again.
// Incorrect password. Try again.
// User sunny blocked!