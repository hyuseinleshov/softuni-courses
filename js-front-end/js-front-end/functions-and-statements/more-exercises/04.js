// Radio Crystals 
function solve(input) {
    const targetThickness = input[0];
    const chunks = input.slice(1);

    chunks.forEach(chunk => {
        console.log(`Processing chunk ${chunk} microns`);

        let currentThickness = chunk;

        let operations = [
            { name: "Cut", effect: thickness => thickness / 4, isApplicable: thickness => thickness / 4 >= targetThickness },
            { name: "Lap", effect: thickness => thickness * 0.8, isApplicable: thickness => thickness * 0.8 >= targetThickness },
            { name: "Grind", effect: thickness => thickness - 20, isApplicable: thickness => thickness - 20 >= targetThickness },
            { name: "Etch", effect: thickness => thickness - 2, isApplicable: thickness => thickness - 2 >= targetThickness },
        ];

        let count, operationPerformed = false;

        for (let operation of operations) {
            count = 0;
            while (operation.isApplicable(currentThickness)) {
                currentThickness = operation.effect(currentThickness);
                count++;
            }
            if (count > 0) {
                console.log(`${operation.name} x${count}`);
                operationPerformed = true;
            }
            if (operationPerformed) {
                console.log("Transporting and washing");
                currentThickness = Math.floor(currentThickness);
                operationPerformed = false;
            }
        }

        if (currentThickness < targetThickness) {
            console.log("X-ray x1");
            currentThickness += 1;
        }

        console.log(`Finished crystal ${targetThickness} microns`);
    });
}

solve([1375, 50000]);
// Processing chunk 50000 microns
// Cut x2
// Transporting and washing
// Lap x3
// Transporting and washing
// Grind x11
// Transporting and washing
// Etch x3
// Transporting and washing
// X-ray x1
// Finished crystal 1375 microns
solve([1000, 4000, 8100]);
// Processing chunk 4000 microns
// Cut x1
// Transporting and washing
// Finished crystal 1000 microns
// Processing chunk 8100 microns
// Cut x1
// Transporting and washing
// Lap x3
// Transporting and washing
// Grind x1
// Transporting and washing
// Etch x8
// Transporting and washing
// Finished crystal 1000 microns