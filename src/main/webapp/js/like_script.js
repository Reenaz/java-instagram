$(document).ready(function() {
    $(document).on('click', '.like_btn', function(event) {
        event.preventDefault();
        var like_btn = $(this);
        var like_btn_url = $(this).attr('href');
        var post = $(this).parents('div.post')[0];
        var post_id = post.getAttribute('id');
        var likes_count_element = $(post).find('.likes_count strong')[0];
        var count_of_likes = parseInt($(likes_count_element).text());


        if($(this).hasClass('like')) {
            var new_count = +(count_of_likes - 1);
            $.get("like?postId=" + post_id + "&action=delete");
            $(this).removeClass('like');
            $(this).addClass('unlike');
            $(($(post).find('.likes_count strong')[0])).text(new_count);
            $(this).html("<img src=\"/img/unlike.png\" class=\"img-responsive post_like_icon\">")

        }else {
            var new_count = +(count_of_likes + 1);
            $.get("like?postId=" + post_id + "&action=add");
            $(this).removeClass('unlike');
            $(this).addClass('like');
            $(($(post).find('.likes_count strong')[0])).text(new_count);
            $(this).html("<img src=\"/img/like.jpg\" class=\"img-responsive post_like_icon\">")
        }

    });
});

