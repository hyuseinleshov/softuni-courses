document.addEventListener('DOMContentLoaded', solve);

function solve() {
   const form = document.querySelector('#task-input');
   const array = (document.querySelector('input[type="text"]').value).split(', ');
   const content = document.querySelector('#content');

   form.addEventListener('submit', e => {
      e.preventDefault();

      array.forEach(string => {
         const div = document.createElement('div');
         const p = document.createElement('p');

         p.textContent = string;
         p.style.display = 'none';

         div.addEventListener('click', e => {
            e.target.querySelector('p').style.display = 'block';
         });
         div.appendChild(p);
         
         content.appendChild(div);
      });
   });
}