// Book Shelf
function solve(input) {
    const shelves = new Map();

    input.forEach(line => {
        if (line.includes("->")) {
            const [id, genre] = line.split(" -> ");
            if (!shelves.has(id)) {
                shelves.set(id, { genre, books: [] });
            }
        } else if (line.includes(":")) {
            const [bookPart, detailsPart] = line.split(": ");
            const [author, genre] = detailsPart.split(", ");
            const title = bookPart.trim();

            for (const [id, shelf] of shelves.entries()) {
                if (shelf.genre === genre) {
                    shelf.books.push({ title, author });
                    break;
                }
            }
        }
    });

    const sortedShelves = Array.from(shelves.entries())
        .sort((a, b) => b[1].books.length - a[1].books.length);

    sortedShelves.forEach(([id, { genre, books }]) => {
        console.log(`${id} ${genre}: ${books.length}`);
        books.sort((a, b) => a.title.localeCompare(b.title));
        books.forEach(book => {
            console.log(`--> ${book.title}: ${book.author}`);
        });
    });
}

solve([
    '1 -> history',
    '1 -> action',
    'Death in Time: Criss Bell, mystery',
    '2 -> mystery',
    '3 -> sci-fi',
    'Child of Silver: Bruce Rich, mystery',
    'Hurting Secrets: Dustin Bolt, action',
    'Future of Dawn: Aiden Rose, sci-fi',
    'Lions and Rats: Gabe Roads, history',
    '2 -> romance',
    'Effect of the Void: Shay B, romance',
    'Losing Dreams: Gail Starr, sci-fi',
    'Name of Earth: Jo Bell, sci-fi',
    'Pilots of Stone: Brook Jay, history'
]);
// Expected Output:
// 3 sci-fi: 3
// --> Future of Dawn: Aiden Rose
// --> Losing Dreams: Gail Starr
// --> Name of Earth: Jo Bell
// 1 history: 2
// --> Lions and Rats: Gabe Roads
// --> Pilots of Stone: Brook Jay
// 2 mystery: 1
// --> Child of Silver: Bruce Rich
