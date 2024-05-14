<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>メッセージボード</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>メッセージボード アプリケーション</h1>
            </div>
            <div id="content">
                ${param.content}
<%--スクリプト式のrequest.getAttribute("q");　を、
JSTLとEL式に変換して<c:out value="${content}" /></p>とかく。 --%>
            </div>
            <div id="footer">
                by Taro Kirameki.
            </div>
        </div>
    </body>
</html>