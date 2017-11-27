$(document).ready(function() {
    $('#get_person').click(function(event) {
        event.preventDefault();
        var modal = $('#subscribed_modal');
        var list = $(modal).find('.subscribed_list')[0];

        $.get('/getSubscribedPerson').done(function (data) {
            $.each(data, function(index, item) {
                $(list).append("<li class=\"list-group-item subscriber\"><p><img src=\"file/" + item.photo + "\" class=\"subscriber_img img-responsive img-circle\" ><a href=\"/user?userName=" + item.userName + "\">"+ item.userName +"</a></p></li>")
            });
            $('#subscribed_modal').modal('show');
        })
    });

    $('#subscribed_modal ').on('click', function(event) {
        $('#subscribed_modal ').modal('hide');
        $('.subscribed_list').empty();
        console.log(list);
    });


});

