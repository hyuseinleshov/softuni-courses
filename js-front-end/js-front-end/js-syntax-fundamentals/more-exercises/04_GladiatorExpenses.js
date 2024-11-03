function solve(lostFightsCount, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let brokenHelmetCount = 0;
    let brokenSwordCount = 0;
    let brokenShieldCount = 0;
    let brokenArmorCount = 0;
    
    while (lostFightsCount > 0) {
        let brokenItems = 0;

        if (lostFightsCount % 2 == 0) {
            brokenHelmetCount++;
            brokenItems++;
        }
        
        if (lostFightsCount % 3 == 0) {
            brokenSwordCount++;
            brokenItems++;
        }

        if (brokenItems == 2) {
            brokenShieldCount++;

            if (brokenShieldCount % 2 == 0) {
                brokenArmorCount++;
            }
        }

        lostFightsCount--;
    }

    const totalExpenses = (brokenHelmetCount * helmetPrice)
        + (brokenSwordCount * swordPrice)
        + (brokenShieldCount * shieldPrice)
        + (brokenArmorCount * armorPrice);

    console.log(`Gladiator expenses: ${totalExpenses.toFixed(2)} aureus`);
}

solve(7, 2, 3, 4, 5);                // Gladiator expenses: 16.00 aureus
solve(23, 12.50, 21.50, 40, 200);    // Gladiator expenses: 608.00 aureus