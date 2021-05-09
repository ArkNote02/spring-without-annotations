<%= session.getId() %><br/>
<%= session.getAttribute("email") %><br/>
<%
	String email = (String) session.getAttribute("email");
	if (email != null && !"".equals(email)) {
		out.print("<form action=\"/example-1.0.0/logout\" method=\"post\"><input type=\"submit\" value=\"logout\"/></form>");
	} else {
		out.print("<a href=\"/example-1.0.0/login\">login</a>");
	}
%>
