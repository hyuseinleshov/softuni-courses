function projectsCreation(input) {
    let name = input[0];
    let count = input[1];
    let neededTime = count * 3;

    console.log(`The architect ${name} will need ${neededTime} hours to complete ${count} project/s.`)
}

projectsCreation(["George ", "4 "]);