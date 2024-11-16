// Piccolo
function solve(array) {
    let parkingLot = {};

    for (const string of array) {
        const[direction, carNumber] = string.split(', ');

        if (direction == 'IN') {
            parkingLot[carNumber] = direction;
        } else if (direction == 'OUT') {
            delete parkingLot[carNumber];
        }
    }

    const entries = Object.keys(parkingLot);

    if (entries.length > 0) {
        entries.sort().forEach(car => console.log(car));
    } else {
        console.log('Parking Lot is Empty');
    }
}

solve(["IN, CA2844AA", "IN, CA1234TA", "OUT, CA2844AA", "IN, CA9999TT", "IN, CA2866HI", "OUT, CA1234TA", "IN, CA2844AA", "OUT, CA2866HI", "IN, CA9876HH", "IN, CA2822UU"]);
// Expected Output:
// CA2822UU
// CA2844AA
// CA9876HH
// CA9999TT
