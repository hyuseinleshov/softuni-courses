function vacationBookList(input) {
    let pagesCount = Number(input[0]);
    let pages = Number(input[1]);
    let daysCount = Number(input[2]);

    let totalTime = pagesCount / pages;
    let neededHours = totalTime / daysCount;

    console.log(neededHours);
}

vacationBookList(["212 ", "20 ", "2 "]);