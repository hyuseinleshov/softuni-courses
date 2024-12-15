function solve(input) {
    const MAX_CAPACITY = 500;
    const chemicalsCount = input.shift();

    const chemicalsDetails = input.splice(0, chemicalsCount).reduce((details, chemical) => {
        const [chemicalName, quantity] = chemical.split(' # ');
        details[chemicalName] = { quantity: Number(quantity) };
        return details;
    }, {});

    let command = input.shift();

    while (command !== 'End') {
        const tokens = command.split(' # ');
        const action = tokens[0];
        const chemical1 = tokens[1];
        let output = '';

        if (action === 'Mix') {
            const chemical2 = tokens[2];
            const amount = Number(tokens[3]);

            if (
                chemicalsDetails[chemical1]?.quantity >= amount &&
                chemicalsDetails[chemical2]?.quantity >= amount
            ) {
                chemicalsDetails[chemical1].quantity -= amount;
                chemicalsDetails[chemical2].quantity -= amount;
                output = `${chemical1} and ${chemical2} have been mixed. ${amount} units of each were used.`;
            } else {
                output = `Insufficient quantity of ${chemical1}/${chemical2} to mix.`;
            }

        } else if (action === 'Replenish') {
            const amount = Number(tokens[2]);

            if (!chemicalsDetails[chemical1]) {
                output = `The Chemical ${chemical1} is not available in the lab.`;
            } else {
                const actualAdded = Math.min(amount, MAX_CAPACITY - chemicalsDetails[chemical1].quantity);
                chemicalsDetails[chemical1].quantity += actualAdded;

                if (chemicalsDetails[chemical1].quantity === MAX_CAPACITY) {
                    output = `${chemical1} quantity increased by ${actualAdded} units, reaching maximum capacity of ${MAX_CAPACITY} units!`;
                } else {
                    output = `${chemical1} quantity increased by ${actualAdded} units!`;
                }
            }

        } else if (action === 'Add Formula') {
            const formula = tokens[2];

            if (chemicalsDetails[chemical1]) {
                chemicalsDetails[chemical1].formula = formula;
                output = `${chemical1} has been assigned the formula ${formula}.`;
            } else {
                output = `The Chemical ${chemical1} is not available in the lab.`;
            }
        }

        console.log(output);
        command = input.shift();
    }

    Object.entries(chemicalsDetails).forEach(([chemicalName, details]) => {
        const output = `Chemical: ${chemicalName}, Quantity: ${details.quantity}` +
            (details.formula ? `, Formula: ${details.formula}` : '');
        console.log(output);
    });
}

solve([ '4',
    'Water # 200',
    'Salt # 100',
    'Acid # 50',
    'Base # 80',
    'Mix # Water # Salt # 50',
    'Replenish # Salt # 150',
    'Add Formula # Acid # H2SO4',
    'End']);
// Water and Salt have been mixed. 50 units of each were used.
// Salt quantity increased by 150 units!
// Acid has been assigned the formula H2SO4.
// Chemical: Water, Quantity: 150
// Chemical: Salt, Quantity: 200
// Chemical: Acid, Quantity: 50, Formula: H2SO4
// Chemical: Base, Quantity: 80

solve([ '3',
    'Sodium # 300',
    'Chlorine # 100',
    'Hydrogen # 200',
    'Mix # Sodium # Chlorine # 200',
    'Replenish # Sodium # 250',
    'Add Formula # Sulfuric Acid # H2SO4',
    'Add Formula # Sodium # Na',
    'Mix # Hydrogen # Chlorine # 50',
    'End']);
// Insufficient quantity of Sodium/Chlorine to mix.
// Sodium quantity increased by 200 units, reaching maximum capacity of 500 units!
// The Chemical Sulfuric Acid is not available in the lab.
// Sodium has been assigned the formula Na.
// Hydrogen and Chlorine have been mixed. 50 units of each were used.
// Chemical: Sodium, Quantity: 500, Formula: Na
// Chemical: Chlorine, Quantity: 50
// Chemical: Hydrogen, Quantity: 150