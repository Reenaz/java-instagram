$(document).ready(function() {
    $(document).on('click', '.send_btn', function(event) {
        event.preventDefault();
        var like_btn = $(this);
        var like_btn_url = $(this).attr('href');
        var post = $(this).parents('div.post')[0];
        var post_id = post.getAttribute('id');
        var comment_area = $(post).find('.comment_area')[0];
        var comment_txt = $(comment_area).text();
        console.log(comment_txt);

        $.ajax({
            type: 'POST',
            url: '/comment',
            data: '',
            success: function(data){
                $('.results').html(data);
            }
        });

        jQuery.post("/comment", { comment: comment_txt, postId: post_id })
            .done(function(data) {
                alert("Data Loaded: " + data);
            });


    });
});


