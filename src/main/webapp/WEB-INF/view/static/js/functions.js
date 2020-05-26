function checkPw(form) {
    pw1 = form.pas1.value;
    pw2 = form.pas2.value;

    if (pw1 != pw2) {
        alert("\nВы ввели в поле \"Повторить\" пароль отличный от введенного в поле \"Пароль\".")
        return false;
    } else return true;
}
