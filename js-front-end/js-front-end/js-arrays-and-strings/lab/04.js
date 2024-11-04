// Substring
function solve(string, startingIndex, count) {
    let substring = string.substring(startingIndex, startingIndex + count);
    console.log(substring);
}

solve('ASentence', 1, 8);  // Sentence
solve('SkipWord', 4, 7);   // Word