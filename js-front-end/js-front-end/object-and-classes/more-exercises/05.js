// School Register
function solve(input) {
    const register = {};

    input.forEach(line => {
        const [namePart, gradePart, scorePart] = line.split(', ');
        const name = namePart.split(': ')[1];
        const grade = Number(gradePart.split(': ')[1]);
        const score = Number(scorePart.split(': ')[1]);

        if (score >= 3) {
            const nextGrade = grade + 1;
            if (!register[nextGrade]) {
                register[nextGrade] = [];
            }
            register[nextGrade].push({ name, score });
        }
    });

    const sortedGrades = Object.keys(register).sort((a, b) => a - b);

    sortedGrades.forEach(grade => {
        const students = register[grade];
        const studentNames = students.map(s => s.name).join(', ');
        const averageScore = (students.reduce((sum, s) => sum + s.score, 0) / students.length).toFixed(2);
    
        console.log(`${grade} Grade`);
        console.log(`List of students: ${studentNames}`);
        console.log(`Average annual score from last year: ${averageScore}`);
        console.log('');
    })
}

solve([
    "Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
    "Student name: Ethan, Grade: 9, Graduated with an average score: 5.66",
    "Student name: George, Grade: 8, Graduated with an average score: 2.83",
    "Student name: Steven, Grade: 10, Graduated with an average score: 4.20",
    "Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
    "Student name: Angus, Grade: 11, Graduated with an average score: 2.90",
    "Student name: Bob, Grade: 11, Graduated with an average score: 5.15",
    "Student name: Daryl, Grade: 8, Graduated with an average score: 5.95",
    "Student name: Bill, Grade: 9, Graduated with an average score: 6.00",
    "Student name: Philip, Grade: 10, Graduated with an average score: 5.05",
    "Student name: Peter, Grade: 11, Graduated with an average score: 4.88",
    "Student name: Gavin, Grade: 10, Graduated with an average score: 4.00"
]);
// Expected Output:
// 9 Grade
// List of students: Mark, Daryl
// Average annual score from last year: 5.35
// 10 Grade
// List of students: Ethan, Joey, Bill
// Average annual score from last year: 5.52
// 11 Grade
// List of students: Steven, Philip, Gavin
// Average annual score from last year: 4.42
// 12 Grade
// List of students: Bob, Peter
// Average annual score from last year: 5.02
