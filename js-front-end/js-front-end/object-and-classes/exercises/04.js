// Movies
function solve(array) {
    const moviesMap = {};

    array.forEach(input => {
        if (input.startsWith('addMovie ')) {
            const name = input.slice(9);
            moviesMap[name] = { name };
        } else if (input.includes('directedBy')) {
            const [name, director] = input.split(' directedBy ');
            if (moviesMap[name]) {
                moviesMap[name].director = director;
            }
        } else if (input.includes('onDate')) {
            const [name, date] = input.split(' onDate ');
            if (moviesMap[name]) {
                moviesMap[name].date = date;
            }
        }
    });

    Object.values(moviesMap).forEach(movie => {
        if (movie.name && movie.director && movie.date) {
            console.log(JSON.stringify(movie));
        }
    });
}

solve(["addMovie Fast and Furious", "addMovie Godfather", "Inception directedBy Christopher Nolan", "Godfather directedBy Francis Ford Coppola", "Godfather onDate 29.07.2018", "Fast and Furious onDate 30.07.2018", "Batman onDate 01.08.2018", "Fast and Furious directedBy Rob Cohen"]);
// Expected Output:
// {"name":"Fast and Furious","date":"30.07.2018","director":"Rob Cohen"}
// {"name":"Godfather","director":"Francis Ford Coppola","date":"29.07.2018"}
