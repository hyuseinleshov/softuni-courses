function loadRepos() {
    const username = document.getElementById("username").value;
    const url = `https://api.github.com/users/${username}/repos`;

    fetch(url)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            return response.json();
        })
        .then((data) => {
            const reposList = document.getElementById("repos");
            reposList.innerHTML = "";

            data.forEach((repo) => {
                const listItem = document.createElement("li");
                const link = document.createElement("a");
                link.href = repo.html_url;
                link.textContent = repo.full_name;
                link.target = "_blank";
                listItem.appendChild(link);
                reposList.appendChild(listItem);
            });
        })
        .catch((error) => {
            const reposList = document.getElementById("repos");
            reposList.innerHTML = "";

            const errorItem = document.createElement("li");
            errorItem.textContent = `Error: ${error.message}`;
            reposList.appendChild(errorItem);
        });
}
