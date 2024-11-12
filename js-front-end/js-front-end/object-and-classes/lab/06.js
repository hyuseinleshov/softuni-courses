// Meetings
function solve(input) {
    let meetings = {};

    for (let line of input) {
        let tokens = line.split(' ');
        let weekday = tokens[0];
        let name = tokens[1];

        if (meetings.hasOwnProperty(weekday)) {
            console.log(`Conflict on ${weekday}!`);
        } else {
            meetings[weekday] = name;
            console.log(`Scheduled for ${weekday}`);
        }
    }

    for (let key in meetings) {
        console.log(`${key} -> ${meetings[key]}`);
    }
}

solve([
    "Monday Peter",
    "Wednesday Bill",
    "Monday Tim",
    "Friday Tim"
]);
// Expected Output:
// Scheduled for Monday
// Scheduled for Wednesday
// Conflict on Monday!
// Scheduled for Friday
// Monday -> Peter
// Wednesday -> Bill
// Friday -> Tim

solve([
    "Friday Bob",
    "Saturday Ted",
    "Monday Bill",
    "Monday John",
    "Wednesday George"
]);
// Expected Output:
// Scheduled for Friday
// Scheduled for Saturday
// Scheduled for Monday
// Conflict on Monday!
// Scheduled for Wednesday
// Friday -> Bob
// Saturday -> Ted
// Monday -> Bill
// Wednesday -> George
