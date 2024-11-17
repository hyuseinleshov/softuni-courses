function sumTable() {
    const prices = Array.from(document.querySelectorAll('tbody td:nth-child(2)'));
    const result = document.querySelector('#sum');

    let sum = 0;
    for (let i = 0; i < prices.length - 1; i++) {
        sum += Number(prices[i].textContent);
    }

    result.textContent = sum;
}