function solve() {
   const studentsData = document.querySelectorAll('tbody tr');
   const searchText = document.querySelector('#searchField').value;

   studentsData.forEach(studentsData => {
      studentsData.classList.remove('select');

      const content = studentsData.textContent;
      if (content.includes(searchText) && searchText !== '') {
         studentsData.classList.add('select');
      }
   });
}