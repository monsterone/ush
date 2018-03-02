
$(function(){


var $form=$("#testForm")
$form.on('submit',function(){

                var username = $form.find("input[name='username']").val()
                var password = $form.find("input[name='password']").val()
                var repeatPassword = $form.find("input[name='repeatPassword']").val()
                var email = $form.find("input[name='email']").val()

                 // 验证注册信息有效性
    if (username == "") {
        alert("用户不允许为空！");
        return false;
    } else if (password == "") {
        alert("密码不允许为空！");
        return false;
    } else if (repeatPassword == "") {
        alert("重复密码不允许为空！");
        return false;
    } else if (email == "") {
        alert("电子邮件不允许为空！");
        return false;
    } else if (username.length < 6 || username.length > 20) {
        alert("用户名长度应在6到20个字符之间！");
        return false;
    } else if (username == password || username == repeatPassword) {
        alert("密码或重复密码不能和用户名相同！");
        return false;
    } else if (password.length < 6 || password.length > 20 || repeatPassword.length < 6 || repeatPassword.length > 20) {
        alert("密码或重复密码长度应在6到20个字符之间！");
        return false;
    } else if (password != repeatPassword) {
        alert("密码和重复密码不同，请重新输入！");
        return false;
    } else {
        alert("登录成功！");
        return true;
    }
})


})

   



