function addItem() {
    const newItemText = document.querySelector('#newItemText').value;
    const items = document.querySelector('#items')

    const newItem = document.createElement('li');
    newItem.textContent = newItemText;

    items.appendChild(newItem);
    document.querySelector('#newItemText').value = '';
}
