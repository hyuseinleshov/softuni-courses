function loadRepos() {
   const url = "https://api.github.com/users/testnakov/repos";

   fetch(url)
       .then((response) => {
           if (!response.ok) {
               throw new Error(`Error: ${response.status}`);
           }
           return response.text(); // Convert response to plain text
       })
       .then((data) => {
           const resDiv = document.getElementById("res");
           resDiv.textContent = data; // Update the content of the div
       })
       .catch((error) => {
           console.error("Fetch Error:", error);
       });
}