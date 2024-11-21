function solve() {
    const text = document.querySelector('#input').value.trim();
    const output = document.querySelector('#output');

    const sentences = text.split('.').filter(sentence => sentence.trim().length > 0);

    for (let i = 0; i < sentences.length; i += 3) {
        const paragraphContent = sentences.slice(i, i + 3).join('. ').trim() + '.';
        const p = document.createElement('p');
        p.textContent = paragraphContent;
        output.appendChild(p);
    }
}