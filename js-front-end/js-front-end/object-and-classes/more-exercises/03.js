// Class Laptop
class Laptop {
    constructor(info, quality) {
        this.info = info;
        this.isOn = false;
        this.quality = quality;
    }

    turnOn() {
        if (!this.isOn) {
            this.isOn = true;
            this.quality -= 1;
        }
    }

    turnOff() {
        if (this.isOn) {
            this.isOn = false;
            this.quality -= 1;
        }
    }

    showInfo() {
        const { producer, age, brand } = this.info;
        return JSON.stringify({ producer, age, brand });
    }

    get price() {
        return 800 - (this.info.age * 2) + (this.quality * 0.5);
    }
}

// Test with:
let info = {producer: "Dell", age: 2, brand: "XPS"};
let laptop = new Laptop(info, 10);
laptop.turnOn();
console.log(laptop.showInfo()); // Expected Output: {"producer":"Dell","age":2,"brand":"XPS"}
laptop.turnOff();
console.log(laptop.quality); // Expected Output: 8
laptop.turnOn();
console.log(laptop.isOn); // Expected Output: true
console.log(laptop.price); // Expected Output: 799.5