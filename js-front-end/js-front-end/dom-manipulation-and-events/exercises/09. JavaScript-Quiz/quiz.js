document.addEventListener('DOMContentLoaded', solve);

function solve() {
  const correctAnswers = [
      "onclick", 
      "JSON.stringify()", 
      "A programming API for HTML and XML documents"
  ];

  let currentQuestionIndex = 0;
  let rightAnswers = 0;

  const questions = document.querySelectorAll('.question');
  const results = document.getElementById('results');

  questions[currentQuestionIndex].classList.remove('hidden');

  const answers = document.querySelectorAll('.quiz-answer');
  answers.forEach(answer => {
      answer.addEventListener('click', (e) => {
          const selectedAnswer = e.target.textContent;

          if (selectedAnswer === correctAnswers[currentQuestionIndex]) {
              rightAnswers++;
          }

          questions[currentQuestionIndex].classList.add('hidden');
          currentQuestionIndex++;

          if (currentQuestionIndex < questions.length) {
              questions[currentQuestionIndex].classList.remove('hidden');
          } else {
              displayResults();
          }
      });
  });

  function displayResults() {
      let message;
      if (rightAnswers === correctAnswers.length) {
          message = "You are recognized as top JavaScript fan!";
      } else {
          message = `You have ${rightAnswers} right answer${rightAnswers === 1 ? '' : 's'}`;
      }
      results.textContent = message;
  }
}