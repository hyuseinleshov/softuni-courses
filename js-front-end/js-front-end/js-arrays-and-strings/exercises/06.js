// Modern Times of #(HashTag)
function solve(sentence) {
    let words = sentence.split(' ');
    let regex = /^[a-zA-Z]+$/;

    for (let word of words) {
        if (word.startsWith('#') && word.length > 1) {
            let substring = word.substring(1, word.length);

            if (regex.test(substring)) {
                console.log(substring);
            }
        }
    }
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia'); 
// Output:
// special
// socialMedia

solve('The symbol # is known #variously in English-speaking #regions as the #number sign'); 
// Output:
// variously
// regions
// number