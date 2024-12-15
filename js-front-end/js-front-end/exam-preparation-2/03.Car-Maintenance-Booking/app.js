const BASE_URL = 'http://localhost:3030/jsonstore/appointments';

const carModelInput = document.querySelector('#car-model');
const carServiceInput = document.querySelector('#car-service');
const dateInput = document.querySelector('#date');
const addAppointmentBtn = document.querySelector('#add-appointment');
const editAppointmentBtn = document.querySelector('#edit-appointment');
const loadAppointmentsBtn = document.querySelector('#load-appointments');
const appointmentsList = document.querySelector('#appointments-list');

loadAppointmentsBtn.addEventListener('click', loadAppointments);
addAppointmentBtn.addEventListener('click', addAppointment);

loadAppointments();

function createAppointmentLi(values) {
    const [ model, service, date, _id ] = Object.values(values);

    const appointmentLi = createElement('li', { className: 'appointment', id: _id }, appointmentsList);
    createElement('h2', { className: 'model', textContent: model }, appointmentLi);
    createElement('h3', { className: 'service', textContent: service }, appointmentLi);
    createElement('h3', { className: 'date', textContent: date }, appointmentLi);
    const buttonsAppointmentDiv = createElement('div', { className: 'buttons-appointment' }, appointmentLi);
    const changeButton = createElement('button', { className: 'change-btn', textContent: 'Change' }, buttonsAppointmentDiv);
    const deleteButton = createElement('button', { className: 'delete-btn', textContent: 'Delete' }, buttonsAppointmentDiv);

    changeButton.addEventListener('click', changeAppointment);
    deleteButton.addEventListener('click', () => deleteAppointment(_id));
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
    carModelInput.value = '';
    carServiceInput.value = '';
    dateInput.value = '';
}

async function loadAppointments() {
    appointmentsList.innerHTML = '';

    const response = await fetch(BASE_URL);
    const appointments = await response.json();

    Object.values(appointments).forEach(values => {
        createAppointmentLi(values);
    });
    editAppointmentBtn.disabled = true;
}

async function addAppointment() {
    const model = carModelInput.value;
    const service = carServiceInput.value;
    const date = dateInput.value;

    if (!model || !service || !date) return;

    const appointmentObject = { model, service, date };
    await fetch(BASE_URL, {
        method: 'POST',
        body: JSON.stringify(appointmentObject)
    });

    loadAppointments();
    clearInputFields();
}

function changeAppointment(e) {
    const currentAppointmentLi = e.currentTarget.closest('.appointment');

    const model = currentAppointmentLi.querySelector('.model').textContent;
    const service = currentAppointmentLi.querySelector('.service').textContent;
    const date = currentAppointmentLi.querySelector('.date').textContent;

    carModelInput.value = model;
    carServiceInput.value = service;
    dateInput.value = date;

    addAppointmentBtn.disabled = true;
    editAppointmentBtn.disabled = false;

    editAppointmentBtn.addEventListener('click', () => editAppointment(currentAppointmentLi.id));
}

async function editAppointment(id) {
    const model = carModelInput.value;
    const service = carServiceInput.value;
    const date = dateInput.value;

    console.log(model)

    if (!model || !service || !date) return;

    const appointmentObject = { model, service, date, id };
    await fetch(BASE_URL + `/${id}`, {
        method: 'PUT',
        body: JSON.stringify(appointmentObject)
    });

    editAppointmentBtn.disabled = true;
    addAppointmentBtn.disabled = false;

    loadAppointments();
    clearInputFields();
}

async function deleteAppointment(id) {
    await fetch(BASE_URL + `/${id}`, { method: 'DELETE' });
    loadAppointments();
}
