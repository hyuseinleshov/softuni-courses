// NxN Matrix
function solve(n) {
    for (let i = 0; i < n; i++) {
        let result = '';
        for (let j = 0; j < n; j++) {
            result += n + ' ';
        }
        
        console.log(result.trim());
    }
}

solve(3);  // Expected Output:
           // 3 3 3
           // 3 3 3
           // 3 3 3

solve(7);  // Expected Output:
           // 7 7 7 7 7 7 7
           // (Repeated for 7 lines)