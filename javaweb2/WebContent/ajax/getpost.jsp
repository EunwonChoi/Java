<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String irum = request.getParameter("name");
String nai = request.getParameter("age");
System.out.print(irum + " " + nai);    //server computer의 console로 날라감
//out.print(irum + "님의 나이는 " + nai);   //client broswer로 날라감
%>
<%=irum + "님의 나이는 " + nai %> <!-- out.print와 같음 -->


<!-- broswer computer의 console로 날라감 
<script>
console.log('aa
a');
</script>
-->