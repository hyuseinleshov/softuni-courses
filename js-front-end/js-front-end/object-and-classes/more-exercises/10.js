// Comments
function solve(input) {
    const users = new Set();
    const articles = new Set();
    const comments = {};

    input.forEach(line => {
        if (line.startsWith("user ")) {
            const username = line.split("user ")[1];
            users.add(username);
        } else if (line.startsWith("article ")) {
            const articleName = line.split("article ")[1];
            articles.add(articleName);
        } else if (line.includes(" posts on ")) {
            const [userPart, rest] = line.split(" posts on ");
            const username = userPart.trim();
            const [articlePart, commentPart] = rest.split(": ");
            const articleName = articlePart.trim();
            const [commentTitle, commentContent] = commentPart.split(", ");

            if (users.has(username) && articles.has(articleName)) {
                if (!comments[articleName]) {
                    comments[articleName] = [];
                }
                comments[articleName].push({
                    username,
                    title: commentTitle,
                    content: commentContent,
                });
            }
        }
    });

    const sortedArticles = Object.entries(comments)
        .sort((a, b) => b[1].length - a[1].length);

    sortedArticles.forEach(([article, commentList]) => {
        console.log(`Comments on ${article}`);
        commentList
            .sort((a, b) => a.username.localeCompare(b.username))
            .forEach(({ username, title, content }) => {
                console.log(`--- From user ${username}: ${title} - ${content}`);
            });
    });
}

solve([
    'user aUser123',
    'someUser posts on someArticle: NoTitle, stupidComment',
    'article Books',
    'article Movies',
    'article Shopping',
    'user someUser',
    'user uSeR4',
    'user lastUser',
    'uSeR4 posts on Books: I like books, I do really like them',
    'uSeR4 posts on Movies: I also like movies, I really do',
    'someUser posts on Shopping: title, I go shopping every day',
    'someUser posts on Movies: Like, I also like movies very much'
]);
// Expected Output:
// Comments on Movies
// --- From user someUser: Like - I also like movies very much
// --- From user uSeR4: I also like movies - I really do
// Comments on Books
// --- From user uSeR4: I like books - I do really like them
// Comments on Shopping
// --- From user someUser: title - I go shopping every day
