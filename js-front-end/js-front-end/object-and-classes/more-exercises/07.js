// Sequences
function solve(input) {
    const sequences = new Map();

    input.forEach(jsonString => {
        const array = JSON.parse(jsonString).sort((a, b) => b - a);

        const key = JSON.stringify(array);

        if (!sequences.has(key)) {
            sequences.set(key, array);
        }
    });

    const sortedSequences = Array.from(sequences.values()).sort((a, b) => a.length - b.length);

    sortedSequences.forEach(array => {
        console.log(`[${array.join(', ')}]`);
    });
}

solve([
    "[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"
]);
// Expected Output:
// [13, 10, 2, 1, 0, -17]
// [4, 3, 2, 1, 0, -1, -2, -3]
