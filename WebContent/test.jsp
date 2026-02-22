<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>

</head>
<body>
<%  
int n=Integer.parseInt(request.getParameter("val"));  
  
for(int i=1;i<=10;i++)  
out.print(i*n+"<br>");  
  
%>
</body>
 
</html>