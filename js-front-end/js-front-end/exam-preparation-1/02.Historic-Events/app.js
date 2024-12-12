window.addEventListener("load", solve);

function solve() {
  const addEventSection = document.querySelector('#add-event');
  const addEventForm = addEventSection.querySelector('form');
  const nameInput = addEventForm.querySelector('#name');
  const timeInput = addEventForm.querySelector('#time');
  const descriptionTextarea = addEventForm.querySelector('#description');
  const addButton = addEventForm.querySelector('#add-btn');

  const eventsDiv = document.querySelector('#events');
  const previewList = eventsDiv.querySelector('#preview-list');
  const archiveList = eventsDiv.querySelector('#archive-list');

  addEventForm.addEventListener('submit', addEventHandler);

  function addEventHandler(e) {
    e.preventDefault();

    const name = nameInput.value;
    const time = timeInput.value;
    const description = descriptionTextarea.value;

    if (!name || !time || !description) return;
    
    addEventPreview(name, time, description);

    clearInputFields();
    addButton.disabled = true;
  }

  function addEventPreview(name, time, description) {
    const listItem = document.createElement('li');

    const article = document.createElement('article');

    const nameP = document.createElement('p');
    nameP.className = 'name-info';
    nameP.textContent = name;

    const timeP = document.createElement('p');
    timeP.className = 'time-info';
    timeP.textContent = time;

    const descriptionP = document.createElement('p');
    descriptionP.className = 'description-info';
    descriptionP.textContent = description;

    article.appendChild(nameP);
    article.appendChild(timeP);
    article.appendChild(descriptionP);

    const buttonsDiv = document.createElement('div');
    buttonsDiv.className = 'buttons';

    const editButton = document.createElement('button');
    editButton.className = 'edit-btn';
    editButton.textContent = 'Edit';

    editButton.addEventListener('click', editInfoHandler);

    const nextButton = document.createElement('button');
    nextButton.className = 'next-btn';
    nextButton.textContent = 'Next';

    nextButton.addEventListener('click', nextButtonHandler);

    buttonsDiv.appendChild(editButton);
    buttonsDiv.appendChild(nextButton);

    listItem.appendChild(article);
    listItem.appendChild(buttonsDiv);

    previewList.appendChild(listItem);
  }

  function editInfoHandler(e) {
    const currentListItem = ((e.currentTarget).parentElement.parentElement);
    const currentArticle = currentListItem.querySelector('article');
    
    const name = currentArticle.querySelector('p.name-info').textContent;
    const time = currentArticle.querySelector('p.time-info').textContent;
    const description = currentArticle.querySelector('p.description-info').textContent;

    console.log(currentArticle);

    nameInput.value = name;
    timeInput.value = time;
    descriptionTextarea.value = description;

    currentListItem.remove();
    addButton.disabled = false;
  }

  function nextButtonHandler(e) {
    const currentListItem = ((e.currentTarget).parentElement.parentElement);

    currentListItem.remove();
    archiveList.appendChild(currentListItem);

    currentListItem.querySelector('.buttons').remove();

    const archiveButton = document.createElement('button');
    archiveButton.className = 'archive-btn';
    archiveButton.textContent = 'Archive';

    archiveButton.addEventListener('click', () => {
      currentListItem.remove();
      addButton.disabled = false;
    });

    currentListItem.appendChild(archiveButton);
  }

  function clearInputFields() {
    nameInput.value = '';
    timeInput.value = '';
    descriptionTextarea.value = '';
  }
}