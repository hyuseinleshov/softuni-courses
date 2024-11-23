document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const email = document.querySelector('#email');

    email.addEventListener('change', event => {
        const currentEmail = event.currentTarget;
        const regex = new RegExp('^[a-z]+@[a-z]+\.[a-z]+$');

        if (regex.test(currentEmail.value)) {
            currentEmail.classList.remove('error');
        } else {
            currentEmail.classList.add('error');
        }
    });
}
