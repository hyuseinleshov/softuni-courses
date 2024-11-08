// Reveal Words
function solve(string, sentence) {
    let words = string.split(', ');

    for (let word of words) {
        sentence = sentence.replace('*'.repeat(word.length), word);
    }

    console.log(sentence);
}

solve('great', 'softuni is ***** place for learning new programming languages'); 
// Output: softuni is great place for learning new programming languages

solve('great, learning', 'softuni is ***** place for ******** new programming languages'); 
// Output: softuni is great place for learning new programming languages