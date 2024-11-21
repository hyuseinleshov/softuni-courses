function toggle() {
    const button = document.querySelector('.button');
    const extra = document.querySelector('#extra');

    console.log(button);

    if (button.textContent === 'More') {
        button.textContent = 'Less';
        extra.style.display = 'block';
    } else if (button.textContent === 'Less') {
        button.textContent = 'More';
        extra.style.display = 'none';
    }
}