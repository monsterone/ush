 function checkForm(form) {
        if (form.username.value == "") {
            alert("用户名不能为空!");
            form.username.focus();
            return false;
        }
        if (form.password.value == "") {
            alert("密码不能为空!");
            form.password.focus();
            return false;
        }
        alert("登录成功！")
        return true;
    }