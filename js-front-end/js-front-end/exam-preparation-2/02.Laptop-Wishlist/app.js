window.addEventListener("load", solve);

function solve() {
  const laptopModelInput = document.querySelector('#laptop-model');
  const storageInput = document.querySelector('#storage');
  const priceInput = document.querySelector('#price');
  const addButton = document.querySelector('#add-btn');
  const checkList = document.querySelector('#check-list');
  const laptopsList = document.querySelector('#laptops-list');
  const clearButton = document.querySelector('.clear');

  addButton.addEventListener('click', () => {
      const laptopModel = laptopModelInput.value.trim();
      const storage = parseFloat(storageInput.value);
      const price = parseFloat(priceInput.value);

      if (!validateInputs(laptopModel, storage, price)) {
          alert('Please provide valid input for all fields.');
          return;
      }

      addLaptopToChecklist({ laptopModel, storage, price });
      clearInputFields();
      addButton.disabled = true;
  });

  function validateInputs(model, storage, price) {
      return model && !isNaN(storage) && storage > 0 && !isNaN(price) && price > 0;
  }

  function addLaptopToChecklist({ laptopModel, storage, price }) {
      const laptopItem = createElement('li', {}, checkList);
      const article = createElement('article', {}, laptopItem);

      createElement('p', { textContent: laptopModel }, article);
      createElement('p', { textContent: `Memory: ${storage} TB` }, article);
      createElement('p', { textContent: `Price: ${price}$` }, article);

      const editButton = createElement('button', { textContent: 'edit', className: 'btn edit' }, laptopItem);
      const okButton = createElement('button', { textContent: 'ok', className: 'btn ok' }, laptopItem);

      editButton.addEventListener('click', () => editLaptop(laptopItem));
      okButton.addEventListener('click', () => moveToWishlist(laptopItem));
  }

  function editLaptop(laptopItem) {
      const [modelElem, storageElem, priceElem] = laptopItem.querySelectorAll('p');
      laptopModelInput.value = modelElem.textContent;

      storageInput.value = parseFloat(storageElem.textContent.split(' ')[1]);
      priceInput.value = parseFloat(priceElem.textContent.split(' ')[1]);

      laptopItem.remove();
      addButton.disabled = false;
  }

  function moveToWishlist(laptopItem) {
      const clonedItem = laptopItem.cloneNode(true);
      clonedItem.querySelector('.edit').remove();
      clonedItem.querySelector('.ok').remove();
      laptopsList.appendChild(clonedItem);
      laptopItem.remove();
      addButton.disabled = false;
  }

  function clearInputFields() {
      laptopModelInput.value = '';
      storageInput.value = '';
      priceInput.value = '';
  }

  function createElement(tag, attributes, parent) {
      const element = document.createElement(tag);
      for (let key in attributes) {
          element[key] = attributes[key];
      }
      if (parent) parent.appendChild(element);
      return element;
  }

  clearButton.addEventListener('click', () => window.location.reload());
}
