document.addEventListener('DOMContentLoaded', solve);

function solve() {
    function sectionFocusedEventHandler(event) {
        event.currentTarget.parentElement.classList.add('focused');
    }

    function sectionBlurredEventHandler(event) {
        event.currentTarget.parentElement.classList.remove('focused');
    }

    const inputFields = document.querySelectorAll('input[type="text"');
    inputFields.forEach(inputField => {
        inputField.addEventListener('focus', sectionFocusedEventHandler);
        inputField.addEventListener('blur', sectionBlurredEventHandler);
    });
}