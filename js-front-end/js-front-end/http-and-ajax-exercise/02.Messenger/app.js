function attachEvents() {
    const messagesTextarea = document.querySelector('#messages');
    const authorInput = document.querySelector('input[name="author"]');
    const contentInput = document.querySelector('input[name="content"]');
    const submitButton = document.querySelector('#submit');
    const refreshButton = document.querySelector('#refresh');

    const url = 'http://localhost:3030/jsonstore/messenger';

    submitButton.addEventListener('click', async () => {
        const messageObject = {
            author: authorInput.value,
            content: contentInput.value
        };

        if (messageObject.author && messageObject.content) {
            try {
                const response = await fetch(url, {
                    method: 'POST',
                    body: JSON.stringify(messageObject)
                });
                const data = await response.json();
            } catch(error) {
                console.error('Error sending message:', error);
            }

            authorInput.value = '';
            contentInput.value = '';
        }
    });

    refreshButton.addEventListener('click', async () => {
        try {
            const response = await fetch(url);
            const data = await response.json()

            const messages = [];
            Object.values(data).forEach(values => {
                messages.push(`${values.author}: ${values.content}`);
            });

            messagesTextarea.textContent = (messages.join('\n'));
        } catch(error) {
            console.error('Error fetching messages', error);
        }
    });
}

attachEvents();