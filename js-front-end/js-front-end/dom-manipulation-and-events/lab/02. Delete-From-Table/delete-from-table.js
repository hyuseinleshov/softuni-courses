function deleteByEmail() {
    const email = document.querySelector('input[name=email]').value;
    const tableRows = document.querySelectorAll('#customers tbody tr');
    const result = document.querySelector('#result');

    let isFound = false;
    tableRows.forEach(row => {
        if (row.textContent.includes(email)) {
            row.parentNode.removeChild(row);
            result.textContent = 'Deleted.'
            isFound = true;
        }
    });

    if (isFound === false) {
        result.textContent = 'Not found.';
    }

    document.querySelector('input[name=email]').value = '';
}
