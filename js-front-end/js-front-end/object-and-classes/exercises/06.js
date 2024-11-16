// Words Tracker
function solve(input) {
    const wordsToTrack = input[0].split(" ");
    const wordCounts = {};

    wordsToTrack.forEach(word => wordCounts[word] = 0);
    input.slice(1).forEach(word => {
        if (wordCounts.hasOwnProperty(word)) {
            wordCounts[word]++;
        }
    });

    const sortedWordCounts = Object.entries(wordCounts)
    .sort((a, b) => b[1] - a[1]);

    sortedWordCounts.forEach(([word, count]) => {
        console.log(`${word} - ${count}`);
    });
}

solve(["this sentence", "In", "this", "sentence", "you", "have", "to", "count", "the", "occurrences", "of", "the", "words", "this", "and", "sentence", "because", "this", "is", "your", "task"]);
// Expected Output:
// this - 3
// sentence - 2
