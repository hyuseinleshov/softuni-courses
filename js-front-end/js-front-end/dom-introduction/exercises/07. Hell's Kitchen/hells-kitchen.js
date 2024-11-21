function solve() {
    const input = document.querySelector('#inputs textarea').value;
    const array = JSON.parse(input);
    
    const restaurantMap = new Map();
    array.forEach(string => {
        const [restaurantName, workers] = string.split(' - ');
        const workersData = workers.split(', ').map(worker => {
            const [name, salary] = worker.split(' ');
            return { name, salary: Number(salary) || 0 };
        });

        if (!restaurantMap.has(restaurantName)) {
            restaurantMap.set(restaurantName, workersData);
        } else {
            const existingWorkers = restaurantMap.get(restaurantName);
            restaurantMap.set(restaurantName, existingWorkers.concat(workersData));
        }
    });

    const restaurants = Array.from(restaurantMap.entries()).map(([name, workers]) => {
        const averageSalary = workers.reduce((sum, worker) => sum + worker.salary, 0) / workers.length;
        const bestSalary = Math.max(...workers.map(worker => worker.salary));
        return { name, workers, averageSalary, bestSalary };
    });

    const bestRestaurant = restaurants.sort((a, b) => b.averageSalary - a.averageSalary)[0];

    const bestRestaurantElement = document.querySelector('#bestRestaurant p');
    const workersElement = document.querySelector('#workers p');

    bestRestaurantElement.textContent = `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.averageSalary.toFixed(2)} Best Salary: ${bestRestaurant.bestSalary.toFixed(2)}`;

    workersElement.textContent = bestRestaurant.workers
        .sort((a, b) => b.salary - a.salary)
        .map(worker => `Name: ${worker.name} With Salary: ${worker.salary}`)
        .join(' ');
}