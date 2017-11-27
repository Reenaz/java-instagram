$(document).ready(function() {
    $('#get_sub').click(function(event) {
        event.preventDefault();
        var modal = $('#subscribers_modal');
        var list = $(modal).find('.subscribers_list')[0];

        $.get('/getSubscribers').done(function (data) {
            $.each(data, function(index, item) {
                $(list).append("<li class=\"list-group-item subscriber\"><p><img src=\"file/" + item.photo + "\" class=\"subscriber_img img-responsive img-circle\" ><a href=\"/user?userName=" + item.userName + "\">"+ item.userName +"</a></p></li>")
            });
            $('#subscribers_modal').modal('show');
        })
    });

    $('#subscribers_modal ').on('click', function(event) {
        $('#subscribers_modal ').modal('hide');
        $('.subscribers_list').empty();
        console.log(list);
    });


});

