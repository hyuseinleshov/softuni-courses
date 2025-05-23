// Print Every N-th Element from an Array
function solve(array, step) {
    let result = [];

    for (let i = 0; i < array.length; i += step) {
        result.push(array[i]);
    }

    return result;
}

console.log(solve(['5', '20', '31', '4', '20'], 2));   // Output: ['5', '31', '20']
console.log(solve(['dsa', 'asd', 'test', 'tset'], 2)); // Output: ['dsa', 'test']
console.log(solve(['1', '2', '3', '4', '5'], 6));      // Output: ['1']