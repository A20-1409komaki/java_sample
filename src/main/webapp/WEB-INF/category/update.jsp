<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>カテゴリ変更</title>
  <%@ include file="../common/common.jsp"%>
</head>
<body>
<div class = "header">
  <header>
    <h2>カテゴリ変更画面</h2>
    <%@ include file="../common/header.jsp"%>
  </header>
</div>
<div class="main">
  <span class="label label-danger">${Error}</span>
  <form action="/category/update?categoryid=${currentcategory.id}" method="post">
    <div class="form-group">
      <label for="title">カテゴリ名</label><br>
      <input type="text" class="form-control" name="name" id="title" value="${currentcategory.name}"><br>
      <label for="title">色</label><br>
      <input type="color" id="color" data-cke-saved-name="color" name="color" value="${currentcategory.color}"><br>
    </div>
    <button type="submit">送信</button>
  </form>
  <p><a href ="/category/delete?categoryid=${currentcategory.id}">削除</a></p>
</div>
</body>
</html>