$(document).ready(function() {
    $(document).on('click', '#get_sub', function(event) {
        event.preventDefault();
        var modal = $('#subscribers_modal');
        var list = $(modal).find('.subscribers_list')[0];
        $('#subscribers_modal').modal('show');

        $.get('/getSubscribers').done(function (data) {
            $('#subscribers_modal').modal('show');
            $.each(data, function(index, item) {
                console.log(item);
                $(list).append("<p>" + item.userName + "</p>")
            });


        })




    });
});

