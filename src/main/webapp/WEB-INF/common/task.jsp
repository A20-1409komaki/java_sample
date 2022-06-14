<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var = "count" value = "0"/>
<c:forEach items = "${tasks}" var = "item">
  <c:if test="${count != item.categoryId}">
    <c:forEach items = "${categories}" var = "category">
      <c:if test="${category.id == item.categoryId}">
        <h3>${category.name}</h3>
      </c:if>
    </c:forEach>
    <c:set var = "count" value="${item.categoryId}"/>
  </c:if>
  <div class = "task">
    <input type="radio" name = "did" value="${item.id}">
    <label for="${item.id}">${item.name}</label>
    <c:if test="${not empty item.dueAt}"><p>期限：${item.dueAt}</p></c:if>
    <c:if test="${empty item.dueAt}"><p>期限：--------</p></c:if>
    <c:if test="${not empty item.memo}"><p>詳細：${item.memo}</p></c:if>
    <c:if test="${empty item.memo}"><p>詳細：--------</p></c:if>
  </div>
  <br>
</c:forEach>