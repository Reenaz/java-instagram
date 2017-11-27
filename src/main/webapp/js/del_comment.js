$(document).ready(function() {
    $(document).on('click', '.del_comment', function(event) {
        event.preventDefault();
        var post = $(this).parents('div.post')[0];
        var post_id = post.getAttribute('id');
        var comment = $(this).parents('p.comment');
        var comment_id = $(comment).attr('id');
        console.log(comment_id);
        var url = $(this).attr('href');

        var comment_area = $(post).find('.comment_textarea')[0];
        var comment_txt = $(comment_area).val();
        var user_name = $(post).find('.post_header a strong').text();
        var comments_area = $(post).find('.comments');
        console.log(comment_txt);
        console.log(post_id);

        $.get(url);
        $('#' + comment_id).remove();


    });
});
