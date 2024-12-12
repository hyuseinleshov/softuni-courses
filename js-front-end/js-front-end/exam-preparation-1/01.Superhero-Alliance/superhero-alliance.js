function solve(input) {
    const n = input.shift();

    const superheroes = input.splice(0, n).reduce((superheroes, superhero) => {
        const tokens = superhero.split('-');

        const superheroName = tokens[0];
        const superpower = tokens[1];
        const energy = tokens[2];

        superheroes[superheroName] = {
            superpower: superpower.split(','),
            energy: Number(energy),
        };

        return superheroes;
    }, {});

    let command = input.shift();

    while(command != 'Evil Defeated!') {
        const tokens = command.split(' * ');

        const type = tokens[0];
        const superheroName = tokens[1];
        const superhero = superheroes[superheroName];
        const superpowers = superhero.superpower;

        let output = '';

        switch(type) {
            case 'Use Power':
                const superpower = tokens[2];
                const requiredEnergy = tokens[3];

                if (superpowers.includes(superpower) && (superhero.energy - requiredEnergy) > 0) {
                    superhero.energy -= requiredEnergy;
                    output = `${superheroName} has used ${superpower} and now has ${superhero.energy} energy!`
                } else {
                    output = `${superheroName} is unable to use ${superpower} or lacks energy!`;
                }
                break;
            case 'Train':
                let trainingEnergy = Number(tokens[2]);

                if (superhero.energy < 100) {
                    if ((superhero.energy + trainingEnergy) > 100) {
                        trainingEnergy = 100 - superhero.energy;
                        superhero.energy = 100;
                    } else {
                        superhero.energy += trainingEnergy;
                    }

                    output = `${superheroName} has trained and gained ${trainingEnergy} energy!`;
                } else {
                    output = `${superheroName} is already at full energy!`;
                }
                break;
            case 'Learn':
                const newSuperpower = tokens[2];

                if (superpowers.includes(newSuperpower)) {
                    output = `${superheroName} already knows ${newSuperpower}.`;
                } else {
                    superpowers.push(newSuperpower);
                    output = `${superheroName} has learned ${newSuperpower}!`;
                }
                break;
        }

        console.log(output);

        command = input.shift();
    }

    for (const [superheroName, values] of Object.entries(superheroes)) {
        console.log(`Superhero: ${superheroName}`);
        const superpowers = (values.superpower).join(', ');
        console.log(` - Superpowers: ${superpowers}`);
        console.log(` - Energy: ${values.energy}`);
    }
}

solve([
        "3",
        "Iron Man-Repulsor Beams,Flight-80",
        "Thor-Lightning Strike,Hammer Throw-10",
        "Hulk-Super Strength-60",
        "Use Power * Iron Man * Flight * 30",
        "Train * Thor * 20",
        "Train * Hulk * 50",
        "Learn * Hulk * Thunderclap",
        "Use Power * Hulk * Thunderclap * 70",
        "Evil Defeated!"
    ]);
// Iron Man has used Flight and now has 50 energy! 
// Thor has trained and gained 20 energy! 
// Hulk has trained and gained 40 energy! 
// Hulk has learned Thunderclap! 
// Hulk has used Thunderclap and now has 30 energy! 
// Superhero: Iron Man 
// - Superpowers: Repulsor Beams, Flight 
// - Energy: 50 
// Superhero: Thor 
// - Superpowers: Lightning Strike, Hammer Throw 
// - Energy: 30 
// Superhero: Hulk 
// - Superpowers: Super Strength, Thunderclap 
// - Energy: 30

solve([
        "2",
        "Iron Man-Repulsor Beams,Flight-20",
        "Thor-Lightning Strike,Hammer Throw-100",
        "Train * Thor * 20",
        "Use Power * Iron Man * Repulsor Beams * 30",
        "Evil Defeated!"
    ]);
// Thor is already at full energy! 
// Iron Man is unable to use Repulsor Beams or lacks energy! 
// Superhero: Iron Man 
// - Superpowers: Repulsor Beams, Fligh
// - Energy: 20 
// Superhero: Thor 
// - Superpowers: Lightning Strike, Hammer Throw
// - Energy: 100

solve([
        "2",
        "Iron Man-Repulsor Beams,Flight-100",
        "Thor-Lightning Strike,Hammer Throw-50",
        "Train * Thor * 20",
        "Learn * Thor * Hammer Throw",
        "Use Power * Iron Man * Repulsor Beams * 30",
        "Evil Defeated!"
    ]);
// Thor has trained and gained 20 energy! 
// Thor already knows Hammer Throw. 
// Iron Man has used Repulsor Beams and now has 70 energy! 
// Superhero: Iron Man 
// - Superpowers: Repulsor Beams, Flight 
// - Energy: 70 
// Superhero: Thor 
// - Superpowers: Lightning Strike, Hammer Throw 
// - Energy: 70
