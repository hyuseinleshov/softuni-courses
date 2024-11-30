document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const showMoreButtons = document.querySelectorAll('button');

    showMoreButtons.forEach(button => {
        button.addEventListener('click', e => {
            const profile = e.currentTarget.parentElement;
            
            const checked = profile.querySelector('input[type="radio"]:checked')
            const isLocked = (checked.id).includes('Lock');

            const hiddenFields = profile.querySelector('.active');
            const isHidden = hiddenFields.classList.contains('hidden-fields');

            if (!isLocked && isHidden) {
                hiddenFields.classList.remove('hidden-fields');
                e.currentTarget.textContent = 'Show less';
            } else if (!isLocked && !isHidden) {
                hiddenFields.classList.add('hidden-fields');
                e.currentTarget.textContent = 'Show more';
            }
        });
    });
}