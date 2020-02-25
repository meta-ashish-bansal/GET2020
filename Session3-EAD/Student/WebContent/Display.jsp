 
<%@page import="com.util.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>



<h2 align="center"><font><strong>Students data in database</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Id</b></td>
<td><b>First Name</b></td>
<td><b>Last Name</b></td>
<td><b>Father Name</b></td>
<td><b>Email</b></td>
<td><b>ClassStudent</b></td>
<td><b>Age</b></td>
<td><b>Update</b></td>
</tr>
<%
ResultSet resultSet = null;
Connection con = null;
PreparedStatement preparedStatement = null;
con = DBConnection.createConnection();

String sql ="SELECT * FROM users";

preparedStatement = con.prepareStatement(sql);
resultSet = preparedStatement.executeQuery(sql);
int count=1;
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%= count++ %></td>
<td><%=resultSet.getString("firstName") %></td>
<td><%=resultSet.getString("lastName") %></td>
<td><%=resultSet.getString("fatherName") %></td>
<td><%=resultSet.getString("Email") %></td>
<td><%=resultSet.getInt("classStudent") %></td>
<td><%=resultSet.getInt("age") %></td>
<td><a href="Update.jsp?id=<%= resultSet.getString("SlNo") %>">update</a></td>


</tr>
<% 
}
%>

</table>