function addItem() {
    const newItemText = document.querySelector('#newItemText').value;
    const items = document.querySelector('#items')

    if (newItemText === '') return;

    const newItem = document.createElement('li');
    newItem.textContent = newItemText;

    const deleteLink = document.createElement('a');
    deleteLink.textContent = '[Delete]';
    deleteLink.href = '#';
    deleteLink.addEventListener('click', deleteItem);

    newItem.appendChild(deleteLink);
    items.appendChild(newItem);

    document.querySelector('#newItemText').value = '';

    function deleteItem(e) {
        e.currentTarget.parentElement.remove();
    }
}