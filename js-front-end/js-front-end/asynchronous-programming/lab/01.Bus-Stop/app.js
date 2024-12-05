function getInfo() {
    const stopId = document.querySelector('#stopId').value;
    const stopName = document.querySelector('#stopName');
    const buses = document.querySelector('#buses');

    stopName.textContent = '';
    buses.innerHTML = '';

    if (stopId) {
        const url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;
        fetch(url)
            .then((response) => response.json())
            .then((stop) => {
                stopName.textContent = stop.name;
                for (const [busId, time] of Object.entries(stop.buses)) {
                    const li = document.createElement('li');
                    li.textContent = `Bus ${busId} arrives in ${time} minutes`;
                    buses.appendChild(li);
                }
            })
            .catch(() => stopName.textContent = 'Error');
    }
}