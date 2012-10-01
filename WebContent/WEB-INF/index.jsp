<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>Membership BBS</title>
<style>
* {
  margin: 0;
  padding: 0;
}
p.error {
  padding: 10px;
  background-color: #fff0f5;
  text-align: center;
  font-weight: bold;
  color: #dc143c;
}
#signup-form {
  width: 300px;
  margin: 20px auto;
}
#login-form {
  width: 300px;
  margin: 20px auto;
}
fieldset {
  padding: 10px;
  border: solid 1px #999;
}
fieldset p {
  padding: 2px 0;
}
fieldset p span.param-name {
  display: inline-block;
  width: 100px;
}
fieldset p.action {
  padding: 4px 0;
  text-align: right;
}
fieldset p.action input[type="submit"] {
  width: 80px;
}
</style>

<c:if test="${error != null}">
<p class="error"><c:out value="${error}" /></p>
</c:if>

<form id="signup-form" action="${pageContext.request.contextPath}/mbbs/signup" method="POST">
  <fieldset>
    <legend>新規登録</legend>
    <p><span class="param-name">ハンドル名</span><input type="text" name="handle"></p>
    <p><span class="param-name">アカウント</span><input type="text" name="account"></p>
    <p><span class="param-name">パスワード</span><input type="password" name="pass"></p>
    <p class="action"><input type="submit" value="登録"></p>
  </fieldset>
</form>

<form id="login-form" action="${pageContext.request.contextPath}/mbbs/login" method="POST">
  <fieldset>
    <legend>すでにアカウントをおもちの方</legend>
    <p><span class="param-name">アカウント</span><input type="text" name="account"></p>
    <p><span class="param-name">パスワード</span><input type="password" name="pass"></p>
    <p class="action"><input type="submit" value="ログイン"></p>
  </fieldset>
</form>
