// Flight Schedule
function solve(data) {
    const allFlights = data[0];
    const changedStatuses = data[1];
    const statusToCheck = data[2][0];
    
    const flights = {};
    
    allFlights.forEach(flight => {
        const [flightNumber, ...destinationParts] = flight.split(' ');
        const destination = destinationParts.join(' ');
        flights[flightNumber] = {
            destination,
            status: "Scheduled"
        };
    });

    changedStatuses.forEach(change => {
        const [flightNumber, newStatus] = change.split(' ');
        if (flights[flightNumber]) {
            flights[flightNumber].status = newStatus;
        }
    });

    const result = [];
    if (statusToCheck === "Ready to fly") {
        for (const flight in flights) {
            if (flights[flight].status === "Scheduled") {
                flights[flight].status = "Ready to fly"; // Update status
                result.push(flights[flight]);
            }
        }
    } else {
        for (const flight in flights) {
            if (flights[flight].status === statusToCheck) {
                result.push(flights[flight]);
            }
        }
    }

    result.forEach(flight => {
        console.log(`{ Destination: '${flight.destination}', Status: '${flight.status}' }`);
    });
}

solve([
    ['WN269 Delaware', 'FL2269 Oregon', 'WN498 Las Vegas', 'WN3145 Ohio', 'WN612 Alabama', 'WN4010 New York', 'WN1173 California', 'DL2120 Texas', 'KL5744 Illinois', 'WN678 Pennsylvania'],
    ['DL2120 Cancelled', 'WN612 Cancelled', 'WN1173 Cancelled', 'SK430 Cancelled'],
    ['Cancelled']
]);
// Expected Output:
// { Destination: 'Alabama', Status: 'Cancelled' }
// { Destination: 'California', Status: 'Cancelled' }
// { Destination: 'Texas', Status: 'Cancelled' }
