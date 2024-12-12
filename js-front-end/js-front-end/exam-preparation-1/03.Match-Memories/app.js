document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const form = document.querySelector('form');
    const hostInput = form.querySelector('#host');
    const scoreInput = form.querySelector('#score');
    const guestInput = form.querySelector('#guest');
    const addMatchBtn = document.querySelector('#add-match');
    const editMatchBtn = document.querySelector('#edit-match');
    const loadMatchesBtn = document.querySelector('#load-matches');
    const matchesList = document.querySelector('#list');

    const baseUrl = 'http://localhost:3030/jsonstore/matches';

    loadMatches();

    loadMatchesBtn.addEventListener('click', loadMatches);

    async function loadMatches() {
        const response = await fetch(baseUrl);
        const matches = await response.json();

        matchesList.innerHTML = '';

        Object.values(matches).forEach(({ host, score, guest, _id }) => {
            const matchLi = createMatchLi(host, score, guest, _id);
            matchesList.appendChild(matchLi);
        });
    }

    function createMatchLi(host, score, guest, id) {
        const matchLi = document.createElement('li');
        matchLi.className = 'match';
        matchLi.setAttribute('id', id);

        const infoDiv = document.createElement('div');
        infoDiv.className = 'info';

        const hostP = document.createElement('p');
        hostP.className = 'host-data'
        hostP.textContent = host;

        const scoreP = document.createElement('p');
        scoreP.textContent = score;
        scoreP.className = 'score-data';

        const guestP = document.createElement('p');
        guestP.textContent = guest;
        guestP.className = 'guest-data';

        infoDiv.appendChild(hostP);
        infoDiv.appendChild(scoreP);
        infoDiv.appendChild(guestP);

        matchLi.appendChild(infoDiv);

        const btnWrapperDiv = document.createElement('div');
        btnWrapperDiv.className = 'btn-wrapper';

        const changeBtn = document.createElement('button');
        changeBtn.className = 'change-btn';
        changeBtn.textContent = 'Change';

        changeBtn.addEventListener('click', changeMatchHandler);

        const deleteBtn = document.createElement('button');
        deleteBtn.className = 'delete-btn';
        deleteBtn.textContent = 'Delete';

        deleteBtn.addEventListener('click', deleteMatchHandler);

        btnWrapperDiv.appendChild(changeBtn);
        btnWrapperDiv.appendChild(deleteBtn);

        matchLi.appendChild(btnWrapperDiv);

        return matchLi;
    }

    addMatchBtn.addEventListener('click', addMatchHandler);

    async function addMatchHandler(e) {
        const host = hostInput.value;
        const score = scoreInput.value;
        const guest = guestInput.value;

        const matchObject = {
            host,
            score,
            guest,
        };

        await fetch(baseUrl, {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(matchObject),
        });

        loadMatches();
        clearInputFields();
    }

    async function changeMatchHandler(e) {
        const currentMatchLi = (e.currentTarget).parentElement.parentElement;
        const currentMatchInfoDiv = currentMatchLi.querySelector('.info');

        const host = currentMatchInfoDiv.querySelector('.host-data').textContent;
        const score = currentMatchInfoDiv.querySelector('.score-data').textContent;
        const guest = currentMatchInfoDiv.querySelector('.guest-data').textContent;

        hostInput.value = host;
        scoreInput.value = score;
        guestInput.value = guest;
        const id = currentMatchLi.id;

        editMatchBtn.disabled = false;

        editMatchBtn.addEventListener('click', (e) => editMatchBtnHandler(e, id));

        addMatchBtn.disabled = true;
    }

    async function editMatchBtnHandler(e, id) {
        const host = hostInput.value;
        const score = scoreInput.value;
        const guest = guestInput.value;

        const matchObject = {
            host,
            score,
            guest,
            _id: id,
        };

        await fetch(baseUrl + `/${id}`, {
            method: 'PUT',
            body: JSON.stringify(matchObject),
        });
        
        clearInputFields();
        loadMatches();

        editMatchBtn.disabled = true;
        addMatchBtn.disabled = false;
    }

    async function deleteMatchHandler(e) {
        const currentMatchLi = (e.currentTarget).parentElement.parentElement;
        const id = currentMatchLi.id;

        await fetch (baseUrl + `/${id}`, {
            method: 'DELETE'
        });

        loadMatches();
    }

    function clearInputFields() {
        hostInput.value = '';
        scoreInput.value = '';
        guestInput.value = '';
    }
}