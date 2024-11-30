document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const conversionRates = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3048,
        in: 0.0254,
    };
  
    const inputField = document.getElementById('inputDistance');
    const inputUnits = document.getElementById('inputUnits');
    const outputUnits = document.getElementById('outputUnits');
    const convertButton = document.querySelector('input[type="button"]');
    const outputField = document.getElementById('outputDistance');
  
    convertButton.addEventListener('click', () => {
        const inputDistance = Number(inputField.value);
        const inputUnit = inputUnits.value;
        const outputUnit = outputUnits.value;
  
        const distanceInMeters = inputDistance * conversionRates[inputUnit];
  
        const result = distanceInMeters / conversionRates[outputUnit];
  
        outputField.value = result;
    });
}