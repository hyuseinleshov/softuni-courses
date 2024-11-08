// Bitcoin "Mining"
function solve(dailyGold) {
    const bitcoinPrice = 11949.16;
    const goldPrice = 67.51;

    let wallet = 0;
    let firstBitcoin = 0;
    let count = 0;

    for (let i = 0; i < dailyGold.length; i++) {
        const day = i + 1;
        let goldForTheDay = dailyGold[i];

        if (day % 3 == 0) {
            goldForTheDay -= goldForTheDay * 0.3;
        }

        let exchangedGold = goldForTheDay * goldPrice;
        wallet += exchangedGold;

        if (wallet >= bitcoinPrice) {
            while (wallet >= bitcoinPrice) {
                wallet -= bitcoinPrice;

                if (count == 0) {
                    count++;
                    firstBitcoin = day;
                } else {
                    count++;
                }
            }
        }
    }

    console.log(`Bought bitcoins: ${count}`);
    if (count > 0) {
        console.log(`Day of the first purchased bitcoin: ${firstBitcoin}`);
    }
    console.log(`Left money: ${wallet.toFixed(2)} lv.`);
}

solve([100, 200, 300]); 
// Expected Output:
// Bought bitcoins: 2
// Day of the first purchased bitcoin: 2
// Left money: 10531.78 lv.

solve([50, 100]); 
// Expected Output:
// Bought bitcoins: 0
// Money left: 10126.50 lv.

solve([3124.15, 504.212, 2511.124]); 
// Expected Output:
// Bought bitcoins: 30
// Day of the first purchased bitcoin: 1
// Money left: 5144.11 lv.