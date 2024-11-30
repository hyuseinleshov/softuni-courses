document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const menu = document.querySelector('#menu');
    const form = document.querySelector('form');

    form.addEventListener('submit', e => {
        e.preventDefault();

        const newItemText = form.querySelector('#newItemText');
        const newItemValue = form.querySelector('#newItemValue');

        if (newItemText.value !== '' && newItemValue.value !== '') {
            const option = document.createElement('option');
            option.textContent = newItemText.value;
            option.setAttribute('value', newItemValue.value);

            menu.append(option);
        }

        newItemText.value = newItemValue.value = '';
    });
}