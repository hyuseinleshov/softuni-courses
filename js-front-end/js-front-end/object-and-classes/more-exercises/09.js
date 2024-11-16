// Armies
function solve(input) {
    const leaders = new Map();

    input.forEach(line => {
        if (line.endsWith('arrives')) {
            const leader = line.split(' arrives')[0];
            if (!leaders.has(leader)) {
                leaders.set(leader, {});
            }
        } else if (line.includes(':')) {
            const [leader, armyInfo] = line.split(': ');
            const [armyName, armyCount] = armyInfo.split(', ');
            if (leaders.has(leader)) {
                leaders.get(leader)[armyName] = Number(armyCount);
            }
        } else if (line.includes('+')) {
            const [armyName, additionalCount] = line.split(' + ');
            for (const leader of leaders.values()) {
                if (leader[armyName] !== undefined) {
                    leader[armyName] += Number(additionalCount);
                    break;
                }
            }
        } else if (line.endsWith('defeated')) {
            // Remove the leader and their armies
            const leader = line.split(' defeated')[0];
            leaders.delete(leader);
        }
    });

    const sortedLeaders = Array.from(leaders.entries())
        .map(([leader, armies]) => ({
            leader,
            totalArmyCount: Object.values(armies).reduce((sum, count) => sum + count, 0),
            armies
        }))
        .sort((a, b) => b.totalArmyCount - a.totalArmyCount);

    sortedLeaders.forEach(({ leader, totalArmyCount, armies }) => {
        console.log(`${leader}: ${totalArmyCount}`);
        const sortedArmies = Object.entries(armies).sort(([, countA], [, countB]) => countB - countA);
        sortedArmies.forEach(([armyName, armyCount]) => {
            console.log(`>>> ${armyName} - ${armyCount}`);
        });
    });
}

solve([
    'Rick Burr arrives',
    'Fergus: Wexamp, 30245',
    'Rick Burr: Juard, 50000',
    'Findlay arrives',
    'Findlay: Britox, 34540',
    'Wexamp + 6000',
    'Juard + 1350',
    'Britox + 4500',
    'Porter arrives',
    'Porter: Legion, 55000',
    'Legion + 302',
    'Rick Burr defeated',
    'Porter: Retix, 3205'
]);
// Expected Output:
// Porter: 58507
// >>> Legion - 55302
// >>> Retix - 3205
// Findlay: 39040
// >>> Britox - 39040
