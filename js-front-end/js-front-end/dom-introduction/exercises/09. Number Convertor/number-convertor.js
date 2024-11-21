function solve() {
    const number = Number(document.querySelector('#input').value);
    const convertTo = document.querySelector('#selectMenuTo option:checked').value;
    const output = document.querySelector('#result');

    let result;
    switch (convertTo) {
        case 'binary':
            result = number.toString(2);
            break;
        case 'hexadecimal':
            result = (number.toString(16)).toUpperCase();
            break;
    }

    output.value = result;
}