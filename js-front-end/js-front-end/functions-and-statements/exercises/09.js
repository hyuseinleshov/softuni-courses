// Loading Bar
function solve(percent) {
    if (percent == 100) {
        console.log('100% Complete!');
        console.log('[%%%%%%%%%%]');
    } else {
        const barsCount = percent / 10;
        const bars = '%'.repeat(percent / 10);
        const remainder = '.'.repeat(10 - barsCount);
        const result = bars + remainder;

        console.log(`${percent}% [${result}]`);
        console.log('Still loading...');
    }
}

solve(30);  // Expected Output:
            // 30% [%%%.......]
            // Still loading...

solve(100); // Expected Output:
            // 100% Complete!
            // [%%%%%%%%%%]