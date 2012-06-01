<%-- 
    Document   : register
    Created on : 31.mai.2012, 19:35:16
    Author     : 490501
--%>
<%@include file="header.jsp"%>
<%-- body here --%>
        <div class="register_area">
            
            <div class="register_box">
                <form action="login?mode=register" method="post" name="register_form" onsubmit="return checkRegInfo()">
                
                    <div id="register_form_wrong_message" class="wrong_message"></div>
                    <label name="lbl_name" id="id_lbl_name">Username:</label><br />
                        <input class="register" id="id_name" type="text" name="name"/><br />
                    <label name="lbl_pass" id="id_lbl_pass">Password:</label><br />
                        <input class="register" id="id_pass1" type="password" name="pass"/><br/>
                    <label name="lbl_pass" id="id_lbl_pass2">Repeat password:</label><br />
                        <input class="register" id="id_pass2" type="password" name="pass2"/><br/>
                    <label name="lbl_mail" id="id_lbl_mail">E-mail:</label><br />
                        <input class="register" id="id_mail1" type="text" name="email"/><br/>
                    <label name="lbl_mail" id="id_lbl_mail2">Repeat e-mail:</label><br />
                        <input class="register" id="id_mail2" type="text" name="email"/><br/> 
                    <input type="submit" value="Send" name="btn_login" />
                </form>
            </div>
        </div>
<%-- end of body --%>
<%@include file="footer.jsp"%>