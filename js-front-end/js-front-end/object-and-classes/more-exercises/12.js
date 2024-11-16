// SoftUni Students
function solve(input) {
    const courses = new Map();

    input.forEach(line => {
        if (line.includes(":")) {
            const [courseName, capacity] = line.split(": ");
            const courseCapacity = Number(capacity);

            if (!courses.has(courseName)) {
                courses.set(courseName, { capacity: courseCapacity, students: [] });
            } else {
                courses.get(courseName).capacity += courseCapacity;
            } 
        } else if (line.includes("joins")) {
            const [studentPart, courseName] = line.split(" joins ");
            const [usernameAndCredits, email] = studentPart.split(" with email ");
            const username = usernameAndCredits.split("[")[0];
            const credits = Number(usernameAndCredits.match(/\[(\d+)\]/)[1]);

            if (courses.has(courseName)) {
                const course = courses.get(courseName);
                if (course.students.length < course.capacity) {
                    course.students.push({ username, email, credits });
                }
            }
        }
    });

    const sortedCourses = Array.from(courses.entries())
        .sort((a, b) => b[1].students.length - a[1].students.length);

    sortedCourses.forEach(([courseName, { capacity, students }]) => {
        const placesLeft = capacity - students.length;
        console.log(`${courseName}: ${placesLeft} places left`);

        students
            .sort((a, b) => b.credits - a.credits)
            .forEach(({ credits, username, email }) => {
                console.log(`--- ${credits}: ${username}, ${email}`);
            });
    });
}

solve([
    'JavaBasics: 2',
    'user1[25] with email user1@user.com joins C#Basics',
    'C#Advanced: 3',
    'JSCore: 4',
    'user2[30] with email user2@user.com joins C#Basics',
    'user13[50] with email user13@user.com joins JSCore',
    'user1[25] with email user1@user.com joins JSCore',
    'user8[18] with email user8@user.com joins C#Advanced',
    'user6[85] with email user6@user.com joins JSCore',
    'JSCore: 2',
    'user11[3] with email user11@user.com joins JavaBasics',
    'user45[105] with email user45@user.com joins JSCore',
    'user007[20] with email user007@user.com joins JSCore',
    'user700[29] with email user700@user.com joins JSCore',
    'user900[88] with email user900@user.com joins JSCore'
]);
// Expected Output:
// JSCore: 0 places left
// --- 105: user45, user45@user.com
// --- 85: user6, user6@user.com
// --- 50: user13, user13@user.com
// --- 29: user700, user700@user.com
// --- 25: user1, user1@user.com
// --- 20: user007, user007@user.com
// JavaBasics: 1 places left
// --- 3: user11, user11@user.com
// C#Advanced: 2 places left
// --- 18: user8, user8@user.com
