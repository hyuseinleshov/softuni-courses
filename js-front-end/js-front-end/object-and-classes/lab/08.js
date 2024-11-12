// Cats
function solve(array) {
    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`)
        }
    }

    let cats = [];

    for (let i = 0; i < array.length; i++) {
        let catData = array[i].split(' ');
        let name, age;
        [name, age] = [catData[0], catData[1]];
        cats.push(new Cat(name, age));
    }

    for (cat of cats) {
        cat.meow();
    }
}

solve(["Mellow 2", "Tom 5"]); 
// Expected Output:
// Mellow, age 2 says Meow
// Tom, age 5 says Meow

solve(["Candy 1", "Poppy 3", "Nyx 2"]);
// Expected Output:
// Candy, age 1 says Meow
// Poppy, age 3 says Meow
// Nyx, age 2 says Meow
