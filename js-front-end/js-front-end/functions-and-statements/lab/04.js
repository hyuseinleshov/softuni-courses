// Orders
function solve(product, quantity) {
    let productPrice;

    switch (product) {
        case 'coffee':
            productPrice = 1.50;
            break;
        case 'water':
            productPrice = 1.00;
            break;
        case 'coke':
            productPrice = 1.40;
            break;
        case 'snacks':
            productPrice = 2.00;
            break;
    }

    const price = productPrice * quantity;
    console.log(price.toFixed(2));
}

solve("water", 5);   // Expected Output: 5.00
solve("coffee", 2);  // Expected Output: 3.00