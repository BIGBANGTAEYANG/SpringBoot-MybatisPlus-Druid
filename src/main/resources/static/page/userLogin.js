function userLogin(){
    $.ajax({
        cache: true,
        type: "POST",
        url:"/userLogin",
        dataType: "json",
        data:{"userName":$("#userName").val(),"passWord":$("#passWord").val()},
        async: false,
        error: function() {
            alert("连接错误");
        },
        success: function(res) {
            if(res.returnCode==200){
                window.location.href="/index";
            }else{
                alert(res.returnMsg);
            }
        }
    });
}


function userRegister(){
    if(document.getElementById("userNoExist").style.display=="block"){
        if($("#passWord").val()===$("#confirmPassword").val()){
            $.ajax({
                cache: true,
                type: "POST",
                url:"/sys/user-info/userRegister",
                dataType: "json",
                data:{"userName":$("#userName").val(),"passWord":$("#passWord").val()},
                error: function() {
                    alert("连接错误");
                },
                success: function(res) {
                    alert(res.returnMsg);
                    window.location.href="/";
                }
            });
        }else{
            alert("密码与确认密码需要一致");
        }
    }else{
        alert("用户名已存在");

    }

}

function userNameSearch() {
    var userName = $("#userName").val();
    if(userName!=""){
        $.ajax({
            cache: true,
            type: "POST",
            url:"/sys/user-info/userNameSearch",
            dataType: "json",
            data:{"userName":userName},
            error: function() {
                alert("连接错误");
            },
            success: function(res) {
                if(res.data==0){
                    document.getElementById("userExist").style.display="none";
                    document.getElementById("userNoExist").style.display="none";
                    document.getElementById("userNoExist").style.display="block";
                }else{
                    document.getElementById("userExist").style.display="none";
                    document.getElementById("userNoExist").style.display="none";
                    document.getElementById("userExist").style.display="block";
                }
            }
        });
    }
}

