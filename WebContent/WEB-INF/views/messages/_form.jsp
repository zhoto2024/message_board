<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">タイトル</label><br/>
<%--リクエストスコープのmessageオブジェクトからデータを参照
して,入力内容の初期値として表示するようにしている。

リクエストスコープは、サーブレットからJSPへ値を渡す
ことができる。リクエストスコープへデータを登録するには
request.setAttribute("データ名", 登録するデータ);
取得するには、getAttributeに書き換える。--%>

<input type="text" name="title" id="title" value="${message.title}"/>
<br/><br/>

<label for="content_msg">メッセージ</label><br />
<input type="text" name="content" id="content_msg" value="${message.content}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}"/>
<button type="submit">投稿</button>