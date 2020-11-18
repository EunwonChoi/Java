<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"
 	import="java.sql.*"   
 %>

<sangpums>
<%

//**contentType="text/xml"은 엄청 중요해요!!(xml로 내보냄)

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	Class.forName("org.mariadb.jdbc.Driver");
}catch(Exception e){
	System.out.println("loading err: " + e);
	return;
}

try{
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
	
	while(rs.next()){
		%>
		<sangpum>
			<code><% out.print(rs.getString("code")); %></code>
			<sang><%=rs.getString("sang") %></sang>
			<su><%=rs.getString("su") %></su>
			<dan><%=rs.getString("dan") %></dan>
		</sangpum>
		<% 
	}
	
	rs.close();
	pstmt.close();
	conn.close();
}catch(Exception e){
	System.out.println("err: " + e);
	return;
}
%>
</sangpums>