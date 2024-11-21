function solve() {
   const towns = document.querySelectorAll('#towns li');
   const searchText = document.querySelector('#searchText').value;
   const result = document.querySelector('#result');

   let matches = 0;
   for (let i = 0; i < towns.length; i++) {
      const currentTown = towns[i];

      currentTown.style = '';

      if (currentTown.textContent.includes(searchText)) {
         currentTown.style.fontWeight = "bold";
         currentTown.style.textDecoration = "underline";

         matches++;
      }
   }

   result.textContent = `${matches} matches found`;
}