function solve() {
  const text = (document.querySelector('#text').value).toLowerCase();
  const namingConvention = document.querySelector('#naming-convention').value;

  if (namingConvention !== 'Camel Case' && namingConvention !== 'Pascal Case') {
    document.querySelector('#result').textContent = 'Error!';
  } else {
    let words = text.split(' ');

    for (let i = 0; i < words.length; i++) {
      if (i === 0 && namingConvention === 'Camel Case') {
        continue;
      }

      const word = words[i];
      words[i] = word[0].toUpperCase() + word.slice(1, word.length);
    }

    document.querySelector('#result').textContent = words.join('');
  }
}