<%-- 
    Document   : error
    Created on : 20-Jun-2012, 14:04:11
    Author     : abnormal
--%>

<%@include file="WEB-INF/jspf/header.jspf"%>
<%-- body here --%>
<%
    if(request.getParameter("msg") != null) {
        out.print(request.getParameter("msg"));
    }
%>
<%-- end of body --%>
<%@include file="WEB-INF/jspf/footer.jspf"%>
