function solve(speed, area) {
    let difference = 0;
    let speedLimit;
    let status;

    switch (area) {
        case 'motorway':
            speedLimit = 130;
            break;
        case 'interstate':
            speedLimit = 90;
            break;
        case 'city':
            speedLimit = 50;
            break;
        case 'residential':
            speedLimit = 20;
            break;
    }

    if (speed > speedLimit) {
        difference = speed - speedLimit;
    }

    if (difference <= 20) {
        status = 'speeding';
    } else if (difference <= 40) {
        status = 'excessive speeding';
    } else {
        status = 'reckless driving';
    }

    if (difference > 0) {
        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`);
    } else {
        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
    }
}

solve(40, 'city');          // Driving 40 km/h in a 50 zone
solve(21, 'residential');   // The speed is 1 km/h faster than the allowed speed of 20 - speeding
solve(120, 'interstate');   // The speed is 30 km/h faster than the allowed speed of 90 - excessive speeding
solve(200, 'motorway');     // The speed is 70 km/h faster than the allowed speed of 130 - reckless driving