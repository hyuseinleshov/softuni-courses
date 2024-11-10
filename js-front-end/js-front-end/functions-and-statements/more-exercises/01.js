// Car Wash
function solve(commands) {
    let percentage = 0;

    for (let command of commands) {
        switch (command) {
            case 'soap':
                percentage += 10;
                break;
            case 'water':
                percentage += percentage *0.2;
                break;
            case 'vacuum cleaner':
                percentage += percentage *0.25;
                break;
            case 'mud':
                percentage -= percentage * 0.1;
                break;
        }
    }

    console.log(`The car is ${percentage.toFixed(2)}% clean.`);
}

solve(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
// The car is 39.00% clean.
solve(["soap", "water", "mud", "mud", "water", "mud", "vacuum cleaner"]);
// The car is 13.12% clean.