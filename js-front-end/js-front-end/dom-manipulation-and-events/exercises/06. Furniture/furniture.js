document.addEventListener('DOMContentLoaded', solve);

function solve() {
  const inputForm = document.querySelector('#input');
  const shopForm = document.querySelector('#shop');
  const shopItems = shopForm.querySelector('table tbody');
  const result = shopForm.querySelector('textarea');

  inputForm.addEventListener('submit', e => {
    e.preventDefault();

    const furniture = JSON.parse(inputForm.querySelector('textarea').value);
    
    for(const piece of furniture) {
      const tr = document.createElement('tr');

      const imageTd = createTd(`<img src="${piece.img}" />`);
      const nameTd = createTd(`<p>${piece.name}</p>`);
      const priceTd = createTd(`<p>${piece.price}</p>`);
      const decFactorTd = createTd(`<p>${piece.decFactor}</p>`);
      const checkboxTd = createTd(`<input type="checkbox" />`);

      tr.append(imageTd, nameTd, priceTd, decFactorTd, checkboxTd);
      shopItems.append(tr);
    }
  });

  shopForm.addEventListener('submit', e => {
    e.preventDefault();

    result.textContent = '';
    let checkedFurniture = [];

    for (const piece of shopItems.children) {
      if (piece.querySelector('input[type="checkbox"]').checked) {
        const name = piece.querySelector('td:nth-child(2) p').textContent;
        const price = piece.querySelector('td:nth-child(3) p').textContent;
        const decFactor = piece.querySelector('td:nth-child(4) p').textContent;

        checkedFurniture.push({
          name: name,
          price: Number(price),
          decFactor: Number(decFactor)
        });
      }
    }

    if (checkedFurniture.length > 0) {
      const names = checkedFurniture.map(piece => piece.name).join(', ');
      const totalPrice = checkedFurniture.reduce((total, piece) => total += piece.price, 0);
      const avgDecFactor = checkedFurniture.reduce((total, piece) => total + piece.decFactor, 0) / checkedFurniture.length;
      
      result.textContent += `Bought furniture: ${names}\n`;
      result.textContent += `Total price: ${totalPrice}\n`;
      result.textContent += `Average decoration factor: ${avgDecFactor}`;
    }
  });

  function createTd(innerHtml) {
    const td = document.createElement('td');
    td.innerHTML = innerHtml;
    return td;
  }
}