function attachEvents() {
    const getWeatherButton = document.querySelector('#submit');
    const locationField = document.querySelector('#location');
    const forecastSection = document.querySelector('#forecast');
    const currentDiv = document.querySelector('#current');
    const upcomingDiv = document.querySelector('#upcoming');

    const weatherSymbols = {
        Sunny: '&#x2600;',         // ☀
        'Partly sunny': '&#x26C5;', // ⛅
        Overcast: '&#x2601;',      // ☁
        Rain: '&#x2614;',          // ☂
        Degrees: '&#176;'          // °
    };

    const locationsUrl = 'http://localhost:3030/jsonstore/forecaster/locations';
    
    getWeatherButton.addEventListener('click', async () => {
        const locationName = locationField.value.trim();

        if (locationName) {
            try {
                forecastSection.style.display = 'block';

                currentDiv.innerHTML = '<div class="label">Current conditions</div>';
                upcomingDiv.innerHTML = '<div class="label">Three-day forecast</div>';

                const locationsResponse = await fetch(locationsUrl);
                const locationsData = await locationsResponse.json();

                const location = locationsData.find(loc => loc.name === locationName);

                if (!location) {
                    throw new Error('Location not found');
                }

                const code = location.code;

                const currentConditionsUrl = `http://localhost:3030/jsonstore/forecaster/today/${code}`;
                const currentResponse = await fetch(currentConditionsUrl);
                const currentData = await currentResponse.json();

                const currentConditionsHTML = `
                    <div class="forecasts">
                        <span class="condition symbol">${weatherSymbols[currentData.forecast.condition]}</span>
                        <span class="condition">
                            <span class="forecast-data">${currentData.name}</span>
                            <span class="forecast-data">${currentData.forecast.low}${weatherSymbols.Degrees}/${currentData.forecast.high}${weatherSymbols.Degrees}</span>
                            <span class="forecast-data">${currentData.forecast.condition}</span>
                        </span>
                    </div>
                `;
                currentDiv.innerHTML += currentConditionsHTML;

                const upcomingConditionsUrl = `http://localhost:3030/jsonstore/forecaster/upcoming/${code}`;
                const upcomingResponse = await fetch(upcomingConditionsUrl);
                const upcomingData = await upcomingResponse.json();

                const upcomingForecastHTML = upcomingData.forecast.map(day => `
                    <span class="upcoming">
                        <span class="symbol">${weatherSymbols[day.condition]}</span>
                        <span class="forecast-data">${day.low}${weatherSymbols.Degrees}/${day.high}${weatherSymbols.Degrees}</span>
                        <span class="forecast-data">${day.condition}</span>
                    </span>
                `).join('');
                upcomingDiv.innerHTML += `<div class="forecast-info">${upcomingForecastHTML}</div>`;
            } catch (error) {
                forecastSection.innerHTML = 'Error';
            }
        }
    });
}

attachEvents();