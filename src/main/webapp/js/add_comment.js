$(document).ready(function() {
    $(document).on('click', '.send_btn', function(event) {
        event.preventDefault();
        var post = $(this).parents('div.post')[0];

        var post_id = post.getAttribute('id');
        var comment_area = $(post).find('.comment_textarea')[0];
        var comment_txt = $(comment_area).val();
        var user_name = $(post).find('.post_header a strong').text();
        var comments_area = $(post).find('.comments');
        console.log(comment_txt);
        console.log(post_id);

        jQuery.post("/comment", { comment: comment_txt, postId: post_id })
            .done(function(data) {
                console.log(data);
                console.log(data.user_name);
                var user_name = data.user_name;
                var comment_id = data.comment_id;
                var new_comment = "<p class=\"comment\" id=\"comment" + comment_id + "\"><strong>" + user_name + ": </strong>" + comment_txt + "<a class=\"del_comment\" href=\"/comment?postId=" + post_id + "&commentId=" + comment_id + "\">удалить</a></p>";
                console.log(new_comment);
                $(comments_area).append(new_comment);
                comment_area.reset();
            });


    });
});


