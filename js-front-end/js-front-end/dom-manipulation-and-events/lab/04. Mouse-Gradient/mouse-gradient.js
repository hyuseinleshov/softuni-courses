function attachGradientEvents() {
    const gradient = document.querySelector('#gradient');
    const result = document.querySelector('#result');

    gradient.addEventListener('mousemove', e => {
        const currentPos = e.offsetX;
        const elementWidth = e.currentTarget.clientWidth;

        const percent = (currentPos / elementWidth) * 100;
        result.textContent = Math.floor(percent) + '%';
    });

    gradient.addEventListener('mouseout', e => {
        result.textContent = '';
    });
}
