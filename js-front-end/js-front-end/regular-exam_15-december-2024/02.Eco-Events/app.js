window.addEventListener("load", solve);

function solve() {
  const emailInput = document.querySelector('#email');
  const eventInput = document.querySelector('#event');
  const locationInput = document.querySelector('#location');
  const nextButton = document.querySelector('#next-btn');
  const previewList = document.querySelector('#preview-list');
  const eventList = document.querySelector('#event-list');

  nextButton.addEventListener('click', () => {
    const email = emailInput.value.trim();
    const event = eventInput.value.trim();
    const location = locationInput.value.trim();

    if (!validateInputs(email, event, location)) return;

    addApplicationToPreviewList(email, event, location);
  });

  function addApplicationToPreviewList(email, event, location) {
    const applicationLi = createElement('li', { className: 'application' }, previewList);
    const article = createElement('article', {}, applicationLi);

    createElement('h4', { textContent: email, className: 'email' }, article);

    const eventP = createElement('p', { className: 'event' }, article);
    createElement('strong', { textContent: 'Event:' }, eventP);
    createElement('br', {}, eventP);
    const eventText = document.createTextNode(event);
    eventP.appendChild(eventText);

    const locationP = createElement('p', { className: 'location' }, article);
    createElement('strong', { textContent: 'Location:' }, locationP);
    createElement('br', {}, locationP);
    const locationText = document.createTextNode(location);
    locationP.appendChild(locationText);

    const editButton = createElement('button', { className: 'action-btn edit', textContent: 'edit' }, applicationLi);
    const applyButton = createElement('button', { className: 'action-btn apply', textContent: 'apply' }, applicationLi);

    editButton.addEventListener('click', () => editApplication(applicationLi));
    applyButton.addEventListener('click', () => addToApprovedEvents(applicationLi));

    nextButton.disabled = true;
    clearInputFields();
  }

  function editApplication(currentApplicationLi) {
    const email = currentApplicationLi.querySelector('.email').textContent;
    const event = currentApplicationLi.querySelector('.event').lastChild.nodeValue;
    const location = currentApplicationLi.querySelector('.location').lastChild.nodeValue;

    emailInput.value = email;
    eventInput.value = event;
    locationInput.value = location;

    currentApplicationLi.remove();

    nextButton.disabled = false;
  }

  function addToApprovedEvents(applicationLi) {
    const clonedItem = applicationLi.cloneNode(true);
    clonedItem.querySelector('.edit').remove();
    clonedItem.querySelector('.apply').remove();
    eventList.appendChild(clonedItem);
    applicationLi.remove();
    nextButton.disabled = false;
  }

  function validateInputs(email, event, location) {
    return email || event || location;
  }

  function clearInputFields() {
    emailInput.value = '';
    eventInput.value = '';
    locationInput.value = '';
  }

  function createElement(tag, attributes, parent) {
      const element = document.createElement(tag);
      for (let key in attributes) {
          element[key] = attributes[key];
      }
      if (parent) parent.appendChild(element);
      return element;
  }
}
