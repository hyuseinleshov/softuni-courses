function attachEvents() {
  const resultsTableBody = document.querySelector('#results tbody');
  const firstNameInput = document.querySelector('input[name="firstName"]');
  const lastNameInput = document.querySelector('input[name="lastName"]');
  const facultyNumberInput = document.querySelector('input[name="facultyNumber"]');
  const gradeInput = document.querySelector('input[name="grade"]');
  const notificationP = document.querySelector('.notification');
  const submitButton = document.querySelector('#submit');

  const url = 'http://localhost:3030/jsonstore/collections/students';

  async function loadStudents() {
      resultsTableBody.innerHTML = '';

      try {
          const response = await fetch(url);
          if (!response.ok) throw new Error('Failed to fetch students.');

          const data = await response.json();
          Object.values(data).forEach(({ firstName, lastName, facultyNumber, grade }) => {
              const tr = createTableRow(firstName, lastName, facultyNumber, grade);
              resultsTableBody.appendChild(tr);
          });
      } catch (error) {
          displayNotification('Error loading students. Please try again.', 'error');
          console.error(error);
      }
  }

  async function addStudent() {
      const firstName = firstNameInput.value.trim();
      const lastName = lastNameInput.value.trim();
      const facultyNumber = facultyNumberInput.value.trim();
      const grade = gradeInput.value.trim();

      if (!validateInputs(firstName, lastName, facultyNumber, grade)) {
          return;
      }

      const newStudent = {
          firstName,
          lastName,
          facultyNumber,
          grade: grade,
      };

      try {
          const response = await fetch(url, {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify(newStudent),
          });

          if (!response.ok) throw new Error('Failed to add student.');

          displayNotification('Student added successfully.', 'success');
          clearInputs();
          loadStudents();
      } catch (error) {
          displayNotification('Error adding student. Please try again.', 'error');
          console.error(error);
      }
  }

  function validateInputs(firstName, lastName, facultyNumber, grade) {
      if (!firstName || !lastName || !facultyNumber || !grade) {
          displayNotification('All fields are required.', 'error');
          return false;
      }

      if (isNaN(facultyNumber)) {
          displayNotification('Faculty number must be a valid number.', 'error');
          return false;
      }

      if (isNaN(grade) || grade < 2 || grade > 6) {
          displayNotification('Grade must be a number between 2 and 6.', 'error');
          return false;
      }

      return true;
  }

  function createTableRow(firstName, lastName, facultyNumber, grade) {
      const tr = document.createElement('tr');
      tr.innerHTML = `
          <td>${firstName}</td>
          <td>${lastName}</td>
          <td>${facultyNumber}</td>
          <td>${grade}</td>
      `;
      return tr;
  }

  function displayNotification(message, type) {
      notificationP.textContent = message;
      notificationP.className = `notification ${type}`;
  }

  function clearInputs() {
      firstNameInput.value = '';
      lastNameInput.value = '';
      facultyNumberInput.value = '';
      gradeInput.value = '';
  }

  submitButton.addEventListener('click', addStudent);

  loadStudents();
}

attachEvents();
