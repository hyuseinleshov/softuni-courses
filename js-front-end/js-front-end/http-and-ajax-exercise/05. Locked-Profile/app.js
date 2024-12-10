function lockedProfile() {
    const main = document.querySelector('#main');
    main.innerHTML = '';

    const url = 'http://localhost:3030/jsonstore/advanced/profiles';

    fetch(url)
        .then(response => response.json())
        .then(data => {
            let counter = 1;

            Object.values(data).forEach(profile => {
                const profileDiv = createProfile(profile, counter);
                main.appendChild(profileDiv);
                counter++;
            });
        })
        .catch(error => {
            console.error('Error fetching profiles:', error);
            main.innerHTML = `<p>Error loading profiles. Please try again later.</p>`;
        });

    function createProfile({ username, email, age }, counter) {
        const profileDiv = document.createElement('div');
        profileDiv.className = 'profile';

        profileDiv.innerHTML = `
            <img src="./iconProfile2.png" class="userIcon" />
            <label>Lock</label>
            <input type="radio" name="user${counter}Locked" value="lock" checked>
            <label>Unlock</label>
            <input type="radio" name="user${counter}Locked" value="unlock"><br>
            <hr>
            <label>Username</label>
            <input type="text" name="user${counter}Username" value="${username}" disabled readonly />
            <div class="hiddenFields hidden">
                <hr>
                <label>Email:</label>
                <input type="email" name="user${counter}Email" value="${email}" disabled readonly />
                <label>Age:</label>
                <input type="number" name="user${counter}Age" value="${age}" disabled readonly />
            </div>
        `;

        const toggleButton = document.createElement('button');
        toggleButton.textContent = 'Show more';
        toggleButton.addEventListener('click', () => toggleHiddenFields(profileDiv, toggleButton));

        profileDiv.appendChild(toggleButton);
        return profileDiv;
    }

    function toggleHiddenFields(profileDiv, toggleButton) {
        const hiddenFields = profileDiv.querySelector('.hiddenFields');
        const isUnlocked = profileDiv.querySelector('input[value="unlock"]').checked;

        if (isUnlocked) {
            hiddenFields.classList.toggle('hidden');
            toggleButton.textContent = hiddenFields.classList.contains('hidden') ? 'Show more' : 'Hide it';
        }
    }
}
