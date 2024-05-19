function argumentInfo(... args) {
    for (const value of args) {
        console.log(typeof value + ": " + value)
    }

    let typeCounts = {};

    for (let arg of args) {
        let type = typeof arg;

        if (!typeCounts[type]) {
            typeCounts[type] = 0;
        }

        typeCounts[type]++;
    }

    for (const key in typeCounts) {
        console.log(key + " = " + typeCounts[key])
    }
}

argumentInfo('cat', 42, function () { console.log('Hello world!'); });