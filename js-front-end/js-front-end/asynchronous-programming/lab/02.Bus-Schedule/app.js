function solve() {
    function constructUrl(id) {
        return `http://localhost:3030/jsonstore/bus/schedule/${id}`;
    }

    const info = document.querySelector('#info span.info');
    const departButton = document.querySelector('#depart');
    const arriveButton = document.querySelector('#arrive');

    let currentStopName = '';
    let nextStopId = 'depot';
    
    function depart() {
        fetch(constructUrl(nextStopId))
            .then((response) => response.json())
            .then((data) => {
                info.textContent = `Next stop ${data.name}`
                currentStopName = data.name;
                nextStopId = data.next;

                departButton.disabled = true;
                arriveButton.disabled = false;
            })
            .catch((error) => {
                info.textContent = 'Error';
                departButton.disabled = true;
                arriveButton.disabled = true;
            });
    }

    async function arrive() {
        info.textContent = `Arriving at ${currentStopName}`;
        departButton.disabled = false;
        arriveButton.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();