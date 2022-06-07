<%--
  Created by IntelliJ IDEA.
  User: komakisaki
  Date: 2022/06/02
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>カテゴリ新規登録ページ</title>
</head>
<body>
<h3>カテゴリ新規作成画面</h3>
<span class="label label-danger">${Error}</span>
<form action="/category/insert" method="post">
    <div class="form-group">
        <label for="title">カテゴリ名</label>
        <input type="text" class="form-control"  data-cke-saved-name="name" name="name"><br>
        <label for="title">色</label>
        <input type="color" id="title" data-cke-saved-name="color" name="color"
               value="#e66465">
    </div>
    <button type="submit">送信</button>
</form>
</body>
</html>