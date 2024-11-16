// Inventory
function solve(array) {
    let register = [];

    for (const string of array) {
        let[name, level, items] = string.split(' / ');
        level = Number(level);
        items = items.split(', ');
        register.push({name: name, level: level, items: items});
    }

    register.sort((a, b) => a.level - b.level);

    register.forEach(hero => {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items.join(', ')}`);
    });
}

solve(["Isacc / 25 / Apple, GravityGun", "Derek / 12 / BarrelVest, DestructionSword", "Hes / 1 / Desolator, Sentinel, Antara"]);
// Expected Output:
// Hero: Hes
// level => 1
// items => Desolator, Sentinel, Antara
// Hero: Derek
// level => 12
// items => BarrelVest, DestructionSword
// Hero: Isacc
// level => 25
// items => Apple, GravityGun
