var main = {
    //브라우저의 스코프는 공용공간으로 쓰이기 때문에 나중에 로딩된 js의 init,save가 먼저 로딩된 js의 function을 덮어 쓰게 된다.
    //var index란 객체를 생성해 해당 객체에서 필요한 모든 function을 선언하여 다른 js와 겹칠 위험이 사라진다.
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },
    save: function() {

        alert("hi");
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
