function loadCommits() {
    const username = document.querySelector('#username').value;
    const repository = document.querySelector('#repo').value;
    const url = `https://api.github.com/repos/${username}/${repository}/commits`;

    const commits = document.querySelector('#commits');
    commits.innerHTML = 'Loading...';

    fetch(url)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            commits.innerHTML = '';

            data.forEach(entry => {
                const li = document.createElement('li');
                const authorName = entry.commit.author?.name || 'Unknown Author';
                const message = entry.commit.message || 'No message';
                li.textContent = `${authorName}: ${message}`;
                commits.appendChild(li);
            });
        })
        .catch((error) => {
            commits.innerHTML = '';
            const li = document.createElement('li');
            li.textContent = `Error: ${error.message}`;
            commits.appendChild(li);
        });
}
