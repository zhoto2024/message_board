<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>メッセージ一覧</h2>
        <ul>

<%-- <c:forEach>は繰り返し処理！
<c:forEach>タグには、次の属性を指定できる。
var="a"→繰り返し処理される値が
代入される変数の名前（ここではa）を指定する。
items="${b}"→bという配列を指定する属性 --%>

            <c:forEach var="message" items="${messages}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${message.id}">
                        <c:out value="${message.id}" />
                    </a>
                    ：<c:out value="${message.title}"></c:out> &gt; <c:out value="${message.content}" />
                </li>
            </c:forEach>
        </ul>

<%--contextPath部分は自動的に
/message_boardに置き換わっている。
<a href="<c:url value='/new' />">新規メッセージの投稿</a>
と記しても同義になる。 --%>

        <p><a href="${pageContext.request.contextPath}/new">新規メッセージの投稿</a></p>

    </c:param>
</c:import>