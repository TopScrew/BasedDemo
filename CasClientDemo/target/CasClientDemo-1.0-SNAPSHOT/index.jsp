<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: screw
  Date: 2019/11/1
  Time: 12:17 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
aaaaaaaaaaaaaaaa
<%
    if (request.getUserPrincipal() != null) {
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
        final Map attributes = principal.getAttributes();
        if (attributes != null) {
            Iterator attributeNames = attributes.keySet().iterator();
            out.println("<b>Attributes:</b>");
            if (attributeNames.hasNext()) {
                out.println("<hr><table border='3pt' width='100%'>");
                out.println("<th colspan='2'>Attributes</th>");
                out.println("<tr><td><b>Key</b></td><td><b>Value</b></td></tr>");
                for (; attributeNames.hasNext(); ) {
                    out.println("<tr><td>");
                    String attributeName = (String) attributeNames.next();
                    out.println(attributeName);
                    out.println("</td><td>");
                    final Object attributeValue = attributes.get(attributeName);
                    if (attributeValue instanceof List) {
                        final List values = (List) attributeValue;
                        out.println("<strong>Multi-valued attribute: " + values.size() + "</strong>");
                        out.println("<ul>");
                        for (Object value : values) {
                            out.println("<li>" + value + "</li>");
                        }
                        out.println("</ul>");
                    } else {
                        out.println(attributeValue);
                    }
                    out.println("</td></tr>");
                }
                out.println("</table>");
            } else {
                out.print("No attributes are supplied by the CAS server.</p>");
            }
        } else {
            out.println("<pre>The attribute map is empty. Review your CAS filter configurations.</pre>");
        }
    } else {
        out.println("<pre>The user principal is empty from the request object. Review the wrapper filter configuration.</pre>");
    }
%>
</body>
</html>
