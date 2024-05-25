function depositCalculator(input) {
    let amountDeposited = Number(input[0]);
    let depositTerm = Number(input[1]);
    let annualInterestRate = Number(input[2]);

    let interest = amountDeposited * (annualInterestRate / 100);
    let interestForOneMonth = interest / 12;

    let sum = amountDeposited + (depositTerm * interestForOneMonth);

    console.log(sum);
}

depositCalculator(["200 ", "3 ", "5.7 "]);