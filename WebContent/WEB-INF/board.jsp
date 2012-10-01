<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>会員制掲示板</title>
<style>
#board {
  width: 600px;
  margin: 10px auto;
  padding: 10px;
}
.message {
  padding: 10px 0;
}
.message .meta {
  border-top: dashed 1px #999;
  border-bottom: solid 1px #999;
  background-color: #f5f5f5;
  padding: 10px 5px;
  font-family: monospace;
  text-align: right;
}
.message .body {
  padding: 5px;
}
form p {
  margin: 0;
  padding: 2px 0;
}
</style>

<div id="board">

<c:if test="${empty messages}">
<p>まだ書き込みはありません。</p>
</c:if>

<c:if test="${not empty messages}">
<c:forEach var="msg" items="${messages}">
  <div class="message">
    <p class="body"><c:out value="${msg.body}" /></p>
    <p class="meta">
      by <span class="poster"><c:out value="${msg.poster}" /></span>
      at <span class="posted-at">${msg.postedAt}</span>
    </p>
  </div>
</c:forEach>
</c:if>

<form action="${pageContext.request.contextPath}/mbbs/board" method="POST">
  <p><textarea name="body" rows="5" cols="50"></textarea></p>
  <p><input type="submit" value="投稿"></p>
</form>

</div>
