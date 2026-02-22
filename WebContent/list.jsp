<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

   <%
   try{
  


       String[] str = new String[10];
       for(int i=0;i<str.length;i++){
    	   str[i]="india";
       }

     
    //jQuery related start
       String query = (String)request.getParameter("q");

       int cnt=1;
       for(int j=0;j<str.length;j++)
       {
           if(str[j].toUpperCase().startsWith(query.toUpperCase()))
           {
              out.print(str[j]+"\n");
              if(cnt>=5)// 5=How many results have to show while we are typing(auto suggestions)
              break;
              cnt++;
            }
       }
    //jQuery related end



}
catch(Exception e){
e.printStackTrace();
}%>