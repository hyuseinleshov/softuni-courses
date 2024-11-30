document.addEventListener('DOMContentLoaded', solve);

function solve() {
    const convertButtons = document.querySelectorAll('input[value="Convert"]');
    const timeUnits = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    };

    convertButtons.forEach(button => {
        button.addEventListener('click', e => {
            e.preventDefault();

            const form = e.currentTarget.parentElement;
            const value = Number(form.querySelector('input[type="number"]').value);
            const unit = form.id;

            const baseValueInDays = value / timeUnits[unit];
            const convertedValues = {
                days: baseValueInDays,
                hours: baseValueInDays * timeUnits.hours,
                minutes: baseValueInDays * timeUnits.minutes,
                seconds: baseValueInDays * timeUnits.seconds
            };

            Object.keys(convertedValues).forEach(unit => {
                document.getElementById(unit).querySelector('input[type="number"]').value = convertedValues[unit].toFixed(2);
            });
        });
    });
}