<%-- 
    Document   : index
    Created on : Apr 29, 2012, 1:55:47 PM
    Author     : 490501
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="main.js"></script>
        <title>Main page</title>
    </head>
    <body>
        <jsp:useBean id="Surface" scope="application" class="entities.Surface" />
        <jsp:useBean id="Surface2" scope="application" class="entities.Surface" />
        <button onclick="addSurface()" name="addSurfaceButton">Add wall</button>
        
        <form id="unitFormID" method="post" name="unitForm">
           
        <input type="submit" value="Save" />
        </form>
        
    </body>
</html>
