// City
function solve(city) {
    let entries = Object.entries(city);
    for(let [key, value] of entries) {
        console.log(`${key} -> ${value}`);
    }
}

solve({
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
});  
// Expected Output:
// name -> Sofia
// area -> 492
// population -> 1238438
// country -> Bulgaria
// postCode -> 1000

solve({
    name: "Plovdiv",
    area: 389,
    population: 1162358,
    country: "Bulgaria",
    postCode: "4000"
});
// Expected Output:
// name -> Plovdiv
// area -> 389
// population -> 1162358
// country -> Bulgaria
// postCode -> 4000
