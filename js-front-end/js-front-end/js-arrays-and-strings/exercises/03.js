// List of Names
function solve(names) {
    names.sort((a, b) => a.localeCompare(b));
    
    for(let i = 0; i < names.length; i++) {
        console.log(`${i + 1}.${names[i]}`);
    }
}

solve(["John", "Bob", "Christina", "Ema"]);   // Output:
                                              // 1. Bob
                                              // 2. Christina
                                              // 3. Ema
                                              // 4. John