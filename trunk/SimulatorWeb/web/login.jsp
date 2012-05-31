<%-- 
    Document   : login
    Created on : Apr 28, 2012, 9:12:25 AM
    Author     : 490501
    Description: Login page
--%>


        <%@include file='header.jsp'%>
        <div class="login_area">
            
            <div class="login_box">
                <form action="login?mode=login" method="post" name="login_form">
                    <label name="lbl_name" id="id_lbl_name">Username:</label>
                    <input class="login" type="text" name="name"/><br />
                    <label name="lbl_pass" id="id_lbl_pass">Password:</label>
                    <input class="login" type="password" name="pass"/><br/>
                    <input type="submit" value="Log in" name="btn_login" />
                    <a href="register.jsp">Sign up</a>
                </form>
            </div>
        </div>
        
        <%@include file="footer.jsp" %> 