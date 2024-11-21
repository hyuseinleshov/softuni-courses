function solve() {
    const headers = document.querySelectorAll('th');
    const output = document.querySelector('#output');

    count = 0;
    const result = [];
    headers.forEach(header => {
        count++;

        const childInput = header.children[0];
        const name = childInput.name;
        if (childInput.checked) {
            const row = document.querySelectorAll(`tr td:nth-child(${count})`);
            
            if (result.length === 0) {
                row.forEach(value => {
                    result.push({
                        [name]: value.textContent
                    })
                });
            } else {
                for (let i = 0; i < result.length; i++) {
                    result[i][name] = row[i].textContent;
                }
            }
        }
    });

    output.textContent = JSON.stringify(result);
}