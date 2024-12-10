function attachEvents() {
    const btnLoadPosts = document.getElementById('btnLoadPosts');
    const btnViewPost = document.getElementById('btnViewPost');
    const postsDropdown = document.getElementById('posts');
    const postTitle = document.getElementById('post-title');
    const postBody = document.getElementById('post-body');
    const postComments = document.getElementById('post-comments');

    const postsUrl = 'http://localhost:3030/jsonstore/blog/posts';
    const commentsUrl = 'http://localhost:3030/jsonstore/blog/comments';

    btnLoadPosts.addEventListener('click', async () => {
        postsDropdown.innerHTML = '';
        try {
            const response = await fetch(postsUrl);
            const data = await response.json();

            for (let postId in data) {
                const option = document.createElement('option');
                option.value = postId;
                option.textContent = data[postId].title;
                postsDropdown.appendChild(option);
            }
        } catch (error) {
            console.error('Error loading posts:', error);
        }
    });

    btnViewPost.addEventListener('click', async () => {
        postTitle.textContent = 'Post Details';
        postBody.textContent = '';
        postComments.innerHTML = '';

        const selectedPostId = postsDropdown.value;
        if (!selectedPostId) {
            alert('Please select a post.');
            return;
        }

        try {
            const responsePosts = await fetch(postsUrl);
            const postsData = await responsePosts.json();

            const post = postsData[selectedPostId];
            postTitle.textContent = post.title;
            postBody.textContent = post.body;

            const responseComments = await fetch(commentsUrl);
            const commentsData = await responseComments.json();

            const postCommentsData = Object.values(commentsData).filter(
                comment => comment.postId === selectedPostId
            );

            postCommentsData.forEach(comment => {
                const li = document.createElement('li');
                li.textContent = comment.text;
                postComments.appendChild(li);
            });
        } catch (error) {
            console.error('Error loading post details or comments:', error);
        }
    });
}

attachEvents();