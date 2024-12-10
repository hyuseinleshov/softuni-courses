function solution() {
    const mainSection = document.querySelector('#main');
    const baseUrl = 'http://localhost:3030/jsonstore/advanced/articles';

    fetch(baseUrl + '/list')
        .then(response => response.json())
        .then(data => {
            Object.values(data).forEach(values => {
                const accordionDiv = createAccordion(values);
                mainSection.appendChild(accordionDiv);
            });
        })
        .catch(error => console.error('Error fetching titles of articles:', error));

    function createAccordion({_id, title}) {
        const accordionDiv = document.createElement('div');
        accordionDiv.className = 'accordion';

        accordionDiv.innerHTML = `
            <div class="head">
                <span>${title}</span>
                <button class="button" id="${_id}">More</button>
            </div>
            <div class="extra"></div>
        `;

        const toggleButton = accordionDiv.querySelector('.button');
        toggleButton.addEventListener('click', () => toggleExtraDiv(_id, accordionDiv, toggleButton));

        return accordionDiv;
    }

    async function toggleExtraDiv(articleId, accordionDiv, toggleButton) {
        const extraDiv = accordionDiv.querySelector('.extra');

        if (toggleButton.textContent === 'More') {
            if (!extraDiv.innerHTML) {
                try {
                    const response = await fetch(`${baseUrl}/details/${articleId}`);
                    const data = await response.json();
                    extraDiv.innerHTML = `<p>${data.content}</p>`;
                } catch (error) {
                    console.error(`Error fetching details for article ${articleId}:`, error);
                    return;
                }
            }

            extraDiv.style.display = 'block';
            toggleButton.textContent = 'Less';
        } else {
            extraDiv.style.display = 'none';
            toggleButton.textContent = 'More';
        }
    }
}

solution();
