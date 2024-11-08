 // The Pyramid of King Djoser
function solve(base, increment) {
    let stone = marble = lapisLazuli = gold = height = 0;
    
    while (base > 0) {
        height++;

        if (base == 1) {
            gold += 1 * increment;
        } else if (base == 2) {
            gold += 4 * increment;
        } else {
            let width = base - 2;

            let bulk = (width * width) * increment;
            stone += bulk;

            let decoration = (base * 4 - 4) * increment;
            if (height % 5 == 0) {
                lapisLazuli += decoration;
            } else {
                marble += decoration;
            }
        }

        base -= 2;
    }

    console.log('Stone required: ' + Math.ceil(stone));
    console.log('Marble required: ' + Math.ceil(marble));
    console.log('Lapis Lazuli required: ' + Math.ceil(lapisLazuli));
    console.log('Gold required: ' + Math.ceil(gold));
    console.log('Final pyramid height: ' + Math.floor(height * increment));
}

solve(11, 1); 
// Expected Output:
// Stone required: 165
// Marble required: 112
// Lapis Lazuli required: 8
// Gold required: 1
// Final pyramid height: 6

solve(11, 0.75); 
// Expected Output:
// Stone required: 124
// Marble required: 84
// Lapis Lazuli required: 6
// Gold required: 1
// Final pyramid height: 4

solve(23, 0.5); 
// Expected Output:
// Stone required: 886
// Marble required: 228
// Lapis Lazuli required: 36
// Gold required: 1
// Final pyramid height: 6