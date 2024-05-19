function personalBMI(name, age, weight, height) {
    let bmi = Math.round(calculateBMI(weight, height / 100));
    let status = "";

    if (bmi < 18.5) {
        status = "underweight";
    } else if (bmi < 25) {
        status = "normal";
    } else if (bmi < 30) {
        status = "overweight";
    } else if (bmi >= 30) {
        status = "obese";
    }

    let person = createPerson(name, age, weight, height, bmi, status);

    console.log(person);
}

function createPerson(name, age, weight, height, bmi, status) {
    let personalInfo = {
        age: age,
        weight: weight,
        height: height
    }

    if (status === "obese") {
        return {name: name, personalInfo, BMI: bmi, status: status, recommendation: "admission required"};
    }

    return {name: name, personalInfo, BMI: bmi, status: status};
}

function calculateBMI(weight, height) {
    return weight / (height * height);
}

personalBMI("Peter", 29, 75, 182);
personalBMI("Honey Boo Boo", 9, 57, 137);