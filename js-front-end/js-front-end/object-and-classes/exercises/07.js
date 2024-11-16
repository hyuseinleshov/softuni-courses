// Odd Occurrences
function solve(sentence) {
    const words = sentence.toLowerCase().split(' ');
    const occurrences = {};

    words.forEach(word => {
        if (occurrences.hasOwnProperty(word)) {
            occurrences[word]++;
        } else {
            occurrences[word] = 1;
        }
    });

    let oddOccurrences = [];
    for (const word in occurrences) {
        if (occurrences[word] % 2 != 0) {
            oddOccurrences.push(word)
        }
    }
    
    console.log(oddOccurrences.join(' '));
}

solve("Java C# Php PHP Java PhP 3 C# 3 1 5 C#");
// Expected Output:
// c# php 1 5
