function solve(input) {
    const farmersCount = input.shift();

    const farmersDetails = input.splice(0, farmersCount).reduce((details, farmer) => {
        let [ farmerName, workArea, tasks ] = farmer.split(' ');
        tasks = tasks.split(',');

        details[farmerName] = { workArea, tasks };
        return details;
    }, {});

    let command = input.shift();
    while (command !== 'End') {
        const tokens = command.split(' / ');
        const [ action, farmerName ] = tokens;
        const farmerTasks = farmersDetails[farmerName].tasks;

        let output = '';
        switch (action) {
            case 'Execute':
                const workArea = tokens[2];
                const task = tokens[3];

                const isInTheCorrectArea = farmersDetails[farmerName].workArea === workArea;
                const canPerformTask = farmerTasks.includes(task)

                if (isInTheCorrectArea && canPerformTask) {
                    output = `${farmerName} has executed the task: ${task}!`;
                } else {
                    output = `${farmerName} cannot execute the task: ${task}.`;
                }
                break;
            case 'Change Area':
                const newWorkArea = tokens[2];

                farmersDetails[farmerName].workArea = newWorkArea;
                output = `${farmerName} has changed their work area to: ${newWorkArea}`;
                break;
            case 'Learn Task':
                const newTask = tokens[2];

                const isTaskKnown = (farmersDetails[farmerName].tasks).includes(newTask);

                if (isTaskKnown) {
                    output = `${farmerName} already knows how to perform ${newTask}.`;
                } else {
                    farmerTasks.push(newTask);
                    output = `${farmerName} has learned a new task: ${newTask}.`;
                }
                break;
        }

        console.log(output);
        command = input.shift();
    }

    Object.entries(farmersDetails).forEach(([farmerName, details]) => {
        const sortedTasks = details.tasks.sort();
        const output = `Farmer: ${farmerName}, Area: ${details.workArea}, Tasks: ${sortedTasks.join(', ')}`;
        console.log(output);
    });
}

solve([
    "2",
    "John garden watering,weeding",
    "Mary barn feeding,cleaning",
    "Execute / John / garden / watering",
    "Execute / Mary / garden / feeding",
    "Learn Task / John / planting",
    "Execute / John / garden / planting",
    "Change Area / Mary / garden",
    "Execute / Mary / garden / cleaning",
    "End"
  ]);
// John has executed the task: watering!
// Mary cannot execute the task: feeding.
// John has learned a new task: planting.
// John has executed the task: planting!
// Mary has changed their work area to: garden
// Mary has executed the task: cleaning!
// Farmer: John, Area: garden, Tasks: planting, watering, weeding
// Farmer: Mary, Area: garden, Tasks: cleaning, feeding

solve([
    "3",
    "Alex apiary harvesting,honeycomb",
    "Emma barn milking,cleaning",
    "Chris garden planting,weeding",
    "Execute / Alex / apiary / harvesting",
    "Learn Task / Alex / beeswax",
    "Execute / Alex / apiary / beeswax",
    "Change Area / Emma / apiary",
    "Execute / Emma / apiary / milking",
    "Execute / Chris / garden / watering",
    "Learn Task / Chris / pruning",
    "Execute / Chris / garden / pruning",
    "End"
  ]);
// Alex has executed the task: harvesting!
// Alex has learned a new task: beeswax.
// Alex has executed the task: beeswax!
// Emma has changed their work area to: apiary
// Emma has executed the task: milking!
// Chris cannot execute the task: watering.
// Chris has learned a new task: pruning.
// Chris has executed the task: pruning!
// Farmer: Alex, Area: apiary, Tasks: beeswax, harvesting, honeycomb
// Farmer: Emma, Area: apiary, Tasks: cleaning, milking
// Farmer: Chris, Area: garden, Tasks: planting, pruning, weeding