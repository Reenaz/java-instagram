/*
$(document).ready(function() {
    $('div.post_info').on('click', 'like_btn', function(event) {
        event.preventDefault();
        var like_btn = $(this);
        var like_btn_url = $(this).attr('href');
        var post_id = $(this).parents('div.post')[0].getAttribute('id');

        $.get(like_btn_url);

        if($(this).hasClass("like")){
            $("<a class=\"like_btn unlike\" href=\"like?postId=" + post_id + "&action=add\"><img src=\"/img/unlike.png\" class=\"img-responsive post_like_icon\"></a>").replaceAll($(this))
        } else{
            $("<a class=\"like_btn like\" href=\"like?postId=" + post_id + "&action=delete\"><img src=\"/img/like.jpg\" class=\"img-responsive post_like_icon\"></a>").replaceAll($(this))
        }

    });
});

*/
