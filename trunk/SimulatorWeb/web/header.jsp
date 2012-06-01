<%-- 
    Document   : header
    Created on : 31.mai.2012, 18:47:12
    Author     : 490501
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css" />
        <script type="text/javascript" src="main.js"></script>
        <title>Main page</title>
    </head>
    <body>
        <%-- menu here --%>
        <div class="menu_main">
            <div class="menu_element"><a class="button" href="index.jsp"><span>Main page</span></a></div>
            <div class="menu_element"><a class="button" href="about.jsp"><span>About</span></a></div>
            <%
                if(session.getAttribute("username") != null) {
            %>
            <div class="menu_element"><a class="button" href="addgame.jsp"><span>Create game</span></a></div>
            <div class="menu_element"><a class="button" href="login?mode=logout"><span>Log out</span></a></div>
            <p class="logged_as">Logged as: <% out.println(session.getAttribute("username")); %></p>
    
    
            <%
                } else {
            %>
            <div class="menu_element"><a class="button" href="login.jsp"><span>Sign in</span></a></div>
            <div class="menu_element"><a class="button" href="register.jsp"><span>Sign up</span></a></div>
            <%
                }
            %>  
        </div>
        