function attachEvents() {
    const phonebookUl = document.querySelector('#phonebook');
    const loadButton = document.querySelector('#btnLoad');
    const personInput = document.querySelector('#person');
    const phoneInput = document.querySelector('#phone');
    const createButton = document.querySelector('#btnCreate');

    const baseUrl = 'http://localhost:3030/jsonstore/phonebook';

    async function loadEntries() {
        phonebookUl.innerHTML = '';

        try {
            const response = await fetch(baseUrl);
            if (!response.ok) throw new Error('Failed to fetch entries.');

            const data = await response.json();
            Object.values(data).forEach(({ person, phone, _id }) => {
                const listItem = createPhonebookEntry(person, phone, _id);
                phonebookUl.appendChild(listItem);
            });
        } catch (error) {
            displayError('Error loading phonebook entries.');
            console.error(error);
        }
    }

    async function createEntry() {
        const person = personInput.value.trim();
        const phone = phoneInput.value.trim();

        if (!person || !phone) {
            displayError('Both person and phone fields are required.');
            return;
        }

        const newEntry = { person, phone };

        try {
            const response = await fetch(baseUrl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newEntry),
            });
            if (!response.ok) throw new Error('Failed to create entry.');

            loadEntries();
        } catch (error) {
            displayError('Error creating phonebook entry.');
            console.error(error);
        } finally {
            personInput.value = '';
            phoneInput.value = '';
        }
    }

    async function deleteEntry(id) {
        try {
            const response = await fetch(`${baseUrl}/${id}`, { method: 'DELETE' });
            if (!response.ok) throw new Error('Failed to delete entry.');

            loadEntries();
        } catch (error) {
            displayError('Error deleting phonebook entry.');
            console.error(error);
        }
    }

    function createPhonebookEntry(person, phone, id) {
        const listItem = document.createElement('li');
        listItem.textContent = `${person}: ${phone}`;

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => deleteEntry(id));

        listItem.appendChild(deleteButton);
        return listItem;
    }

    function displayError(message) {
        alert(message);
    }

    loadButton.addEventListener('click', loadEntries);
    createButton.addEventListener('click', createEntry);
}

attachEvents();