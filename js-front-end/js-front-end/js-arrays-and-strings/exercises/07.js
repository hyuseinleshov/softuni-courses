// String Substring
function solve(word, text) {
    let initialWord = word;
    word = word.toLowerCase();
    text = text.toLowerCase();

    if (text.split(' ').includes(word)) {
        console.log(initialWord);
    } else {
        console.log(word + ' not found!');
    }
}

solve('javascript', 'JavaScript is the best programming language'); 
// Output: javascript

solve('python', 'JavaScript is the best programming language'); 
// Output: python not found!