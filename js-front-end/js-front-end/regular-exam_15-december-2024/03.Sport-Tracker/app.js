const BASE_URL = 'http://localhost:3030/jsonstore/workout';

const workoutInput = document.querySelector('#workout');
const locationInput = document.querySelector('#location');
const dateInput = document.querySelector('#date');

const addWorkoutBtn = document.querySelector('#add-workout');
const editWorkoutBtn = document.querySelector('#edit-workout');

const loadWorkoutBtn = document.querySelector('#load-workout');
const workoutsList = document.querySelector('#list');

workoutsList.innerHTML = '';
loadWorkouts();

addWorkoutBtn.addEventListener('click', addWorkout);
loadWorkoutBtn.addEventListener('click', loadWorkouts);

async function addWorkout() {
    const workout = workoutInput.value;
    const location = locationInput.value;
    const date = dateInput.value;

    if (!workout || !location || !date) return;

    const workoutObject = { workout, location, date };
    await fetch(BASE_URL, {
        method: 'POST',
        body: JSON.stringify(workoutObject)
    });

    loadWorkouts();
    clearInputFields();
}

async function loadWorkouts() {
    workoutsList.innerHTML = '';

    const response = await fetch(BASE_URL);
    const workouts = await response.json();

    Object.values(workouts).forEach(values => {
        createWorkoutEl(values);
    })
}

async function editWorkout(id) {
    const workout = workoutInput.value;
    const location = locationInput.value;
    const date = dateInput.value;

    if (!workout || !location || !date) return;

    const editedWorkoutObject = { workout, location, date };
    await fetch(BASE_URL + `/${id}`, {
        method: 'PUT',
        body: JSON.stringify(editedWorkoutObject)
    });

    loadWorkouts();
    clearInputFields();

    editWorkoutBtn.disabled = true;
    addWorkoutBtn.disabled = false;
}

async function deleteWorkout(workoutEl) {
    await fetch(BASE_URL + `/${workoutEl.id}`, { method: 'DELETE' });
    loadWorkouts();
}

function createWorkoutEl(values) {
    const workoutDiv = createElement('div', { id: values._id, className: 'container' }, workoutsList);

    createElement('h2', { className: 'workout', textContent: values.workout }, workoutDiv);
    createElement('h3', { className: 'date', textContent: values.date }, workoutDiv);
    createElement('h3', { id: 'location', textContent: values.location }, workoutDiv);

    const buttonsDiv = createElement('div', { id: 'buttons-container' }, workoutDiv);

    const changeButton = createElement('button', { className: 'change-btn', textContent: 'Change' }, buttonsDiv);
    const deleteButton = createElement('button', { className: 'delete-btn', textContent: 'Done' }, buttonsDiv);

    changeButton.addEventListener('click', () => changeWorkoutEl(workoutDiv));
    deleteButton.addEventListener('click', () => deleteWorkout(workoutDiv));
}

function changeWorkoutEl(workoutEl) {
    workoutEl.remove();

    const workout = workoutEl.querySelector('.workout').textContent;
    const date = workoutEl.querySelector('.date').textContent;
    const location = workoutEl.querySelector('#location').textContent;

    workoutInput.value = workout;
    locationInput.value = location;
    dateInput.value = date;

    editWorkoutBtn.disabled = false;
    addWorkoutBtn.disabled = true;

    editWorkoutBtn.addEventListener('click', () => editWorkout(workoutEl.id));
}

function createElement(tag, attributes, parent) {
    const element = document.createElement(tag);
    for (const key in attributes) {
        element[key] = attributes[key];
    }
    if (parent) parent.appendChild(element);
    return element;
}

function clearInputFields() {
    workoutInput.value = '';
    locationInput.value = '';
    dateInput.value = '';
}