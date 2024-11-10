// Repeat String
function solve(text, repeatCount) {
    let result = '';

    for (let i = 0; i < repeatCount; i++) {
        result += text;
    }

    return result;
}

console.log(solve("abc", 3));    // Expected Output: abcabcabc
console.log(solve("String", 2)); // Expected Output: StringString