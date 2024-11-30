document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const encodeForm = document.querySelector('#encode');
    const decodeForm = document.querySelector('#decode');
    const senderTextarea = encodeForm.querySelector('textarea');
    const receiverTextarea = decodeForm.querySelector('textarea');

    encodeForm.addEventListener('submit', e => {
        e.preventDefault();

        const message = senderTextarea.value;

        if (message !== '') {
            let encodedMessage = '';

            for (const char of message.split('')) {
                encodedMessage += String.fromCharCode(char.charCodeAt(0) + 1);
            }

            senderTextarea.value = '';
            receiverTextarea.textContent = encodedMessage;
        }
    });

    decodeForm.addEventListener('submit', e => {
        e.preventDefault();

        const encodedMessage = receiverTextarea.textContent;

        if (encodedMessage !== '') {
            let decodedMessage = '';

            for (const char of encodedMessage.split('')) {
                decodedMessage += String.fromCharCode(char.charCodeAt(0) - 1);
            }

            receiverTextarea.textContent = decodedMessage;
        }
    });
}