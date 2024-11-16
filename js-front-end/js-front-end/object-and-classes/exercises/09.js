// Make a Dictionary
function solve(array) {
    let dictionary = {};

    for (const string of array) {
        const object = JSON.parse(string);
        const entries = Object.entries(object);
        
        for (const[term, definition] of entries) {
            dictionary[term] = definition;
        }
    }

    const sortedByTerms = Object.entries(dictionary)
        .sort((a, b) => a[0].localeCompare(b[0]));
    sortedByTerms.forEach(entry => {
        const term = entry[0];
        const definition = entry[1];
        console.log(`Term: ${term} => Definition: ${definition}`)
    });
}

solve(['{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}', '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}', '{"Boiler":"A fuel-burning apparatus or container for heating water."}', '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}', '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}']);
// Expected Output:
// Term: Boiler => Definition: A fuel-burning apparatus or container for heating water.
// Term: Bus => Definition: A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare.
// Term: Coffee => Definition: A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub.
// Term: Microphone => Definition: An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded.
// Term: Tape => Definition: A narrow strip of material, typically used to hold or fasten something.
