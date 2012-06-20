<%-- 
    Document   : login
    Created on : Apr 28, 2012, 9:12:25 AM
    Author     : 490501
    Description: Login page
--%>
        <%@page import="java.net.URLEncoder"%>
<%@include file="WEB-INF/jspf/header.jspf"%>
        <%-- body here --%>
        <%-- if already logged sender tilbake --%>
        <%
            if(session.getAttribute("id") != null) {
                response.sendRedirect("error.jsp?msg=" + URLEncoder.encode("You already logged in", "UTF-8"));
            }
        %>
        <div class="login_area">
            <div class="login_box">
                <form action="user?mode=login" method="post" name="login_form">
                    <label name="lbl_name" id="id_lbl_name">Username:</label>
                    <input class="login" type="text" name="name"/><br />
                    <label name="lbl_pass" id="id_lbl_pass">Password:</label>
                    <input class="login" type="password" name="pass"/><br/>
                    <input type="submit" value="Log in" name="btn_login" />
                    <a href="register.jsp">Sign up</a>
                </form>
            </div>
        </div>
        
        <%-- end of body --%>
        <%@include file="WEB-INF/jspf/footer.jspf"%>
        
        


