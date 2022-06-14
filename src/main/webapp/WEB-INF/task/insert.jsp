<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>タスク新規作成</title>
    <%@ include file="../common/common.jsp"%>
</head>
<body>
<div class = "header">
    <header>
        <h2>タスク新規登録画面</h2>
<%--        <%@ include file="../common/header.jsp"%>--%>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <form action="/task/insert" method="post">
        <div class="form-group">
            <label for="title">タスク名</label><br>
            <input type="text" class="form-control" name="name" id="title"><br>
            <label for="title">場所</label><br>
            <input type="text" class="form-control" name="place" id="place"><br>
            <label for="title">重要度</label><br>
            <select name="importance">
                <c:forEach begin="0" end="10" step="1" varStatus="status">
                    <option value="${status.index}"><c:out value="${status.index}" /></option>
                </c:forEach>
            </select><br>
            <label for="title">メモ</label><br>
            <input type="text" class="form-control" name="memo" id="memo"><br>
            <label for="title">期限日</label><br>
            <input type="date" class="form-control" name="dueAt" id="dueAt"><br>
            <label for="title">カテゴリー</label><br>
            <select name="categoryId">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.getId()}"><c:out value="${category.getName()}" /></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">送信</button>
    </form>
</div>
</body>
</html>