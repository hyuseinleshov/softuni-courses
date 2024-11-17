function extract(content) {
    const text = document.getElementById(content).textContent.trim();
    const regex = /\((.*?)\)/g;

    let result = [];
    let match;
    while ((match = regex.exec(text)) !== null) {
        result.push(match[1]);
    }

    return result.join('; ');
}