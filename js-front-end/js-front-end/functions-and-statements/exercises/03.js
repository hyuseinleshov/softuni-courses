// Characters in Range
function solve(char1, char2) {
    const start = Math.min(char1.charCodeAt(0), char2.charCodeAt(0)) + 1;
    const end = Math.max(char1.charCodeAt(0), char2.charCodeAt(0));

    let result = [];

    for (let i = start; i < end; i++) {
        result.push(String.fromCharCode(i));
    }

    console.log(result.join(' '));
}

solve('a', 'd');   // Expected Output: b c
solve('#', ':');   // Expected Output: $ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9
solve('C', '#');   // Expected Output: $ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? @ A B