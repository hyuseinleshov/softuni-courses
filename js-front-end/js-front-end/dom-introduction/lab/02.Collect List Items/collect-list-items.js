function extractText() {
    const listItems = document.querySelectorAll('#items li');
    const result = document.querySelector('#result');

    for (const li of listItems) {
        result.value += li.textContent + '\n';
    }
}