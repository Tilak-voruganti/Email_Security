 <%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.model.EmailModel"%>
<%@page import="java.util.List"%>
<%@page import="com.configurations.AppConfig"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.model.RegisterModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>VTJCC04</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Raleway:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
<!-- Remember to include jQuery :) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <script src="http://code.jquery.com/jquery-1.7.js"
    type="text/javascript"></script>
<script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
<link
    href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
    rel="stylesheet" type="text/css" />

  <!-- Template Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">
   

  <!-- =======================================================
  * Template Name: Impact - v1.1.1
  * Template URL: https://bootstrapmade.com/impact-bootstrap-business-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <script type="text/javascript">
$( function() {
    $("input#autoText").autocomplete({
       
        source: function(request, response) {
            $.ajax({
                url: "ajax",
                dataType: "json",
                data: request,
                success: function( data, textStatus, jqXHR) {
                    console.log( data);
                    var items = data;
                    response(items);
                },
                error: function(jqXHR, textStatus, errorThrown){
                     console.log( textStatus);
                }
            });
        }
 
    });
});
    
</script>
<script type="text/javascript">
$( function() {
    $("input#autosearch").autocomplete({
       
        source: function(request, response) {
            $.ajax({
                url: "search",
                dataType: "json",
                data: request,
                success: function( data, textStatus, jqXHR) {
                    console.log( data);
                    var items = data;
                    response(items);
                },
                error: function(jqXHR, textStatus, errorThrown){
                     console.log( textStatus);
                }
            });
        }
 
    });
});
    
</script>
<style>
.test1 {
  background-color: red;
  position: relative;
  animation-name: example;
  animation-duration: 4s;
  animation-delay: 1s;
}

@keyframes example {
  0%   {background-color:red; left:0px; top:0px;}
  25%  {background-color:red; left:200px; top:0px;}
  50%  {background-color:red; left:0px; top:0px;}
  75%  {background-color:red; left:200px; top:0px;}
  100% {background-color:red; left:0px; top:0px;}
}
</style>

<style> 
.test {
 
  background: red;
  position: relative;
  animation-name: example;
  animation-duration: 3s;  
  animation-fill-mode: forwards;
}

@keyframes example {
 from {top: 0px;}
  to {left: 200px; background-color: red;}
}
</style>
</head>

<body>

  <!-- ======= Header ======= -->
  <section id="topbar" class="topbar d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
      <div class="contact-info d-flex align-items-center">
        
      </div>
     
    </div>
  </section><!-- End Top Bar -->

  <header id="header" class="header d-flex align-items-center">

    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1>Cloud Computing <span>Project..</span></h1>
      </a>
      <nav id="navbar" class="navbar">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="sendemail.jsp?page=send">Send Email</a></li>
           <li><a href="sendemail.jsp?page=inbox">Inbox</a></li>
            <li><a href="sendemail.jsp?page=sent">Sent</a></li>
              <li><a href="sendemail.jsp?page=search">Search</a></li>
          <li><a href="logout.jsp">Logout</a></li>
         
      </nav><!-- .navbar -->

      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

    </div>
  </header><!-- End Header -->
  <!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="hero">
    <div class="container position-relative" style="height: 100vh">
      <div class="row gy-5" data-aos="fade-in">
        <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center text-center text-lg-start">
        
          
          <div class="d-flex justify-content-center justify-content-lg-start">
            <a href="#about" class=""></a>
            <a href="https://www.youtube.com/watch?v=LXb3EKWsInQ" class="glightbox btn-watch-video d-flex align-items-center"><i class=""></i><span></span></a>
          </div>
        </div>
        <!-- Send email  -->
        <%
        if(request.getParameter("page").equalsIgnoreCase("send")){%>
        	    <div class="col-lg-6 order-1 order-lg-2">
         <%
         RegisterModel rm= (RegisterModel)session.getAttribute("account");
         %>
         ${info }
         ${alert}
     <form action="EmailServlet" method="post">
     <label style="color:#FFF;">From </label>
       <input type="text" name="fromMail" class="form-control" value=<%=rm.getEmailid() %> />
     <label style="color:#FFF;">To</label>
       <input type="text" name="toMail" id="autoText" class="form-control"/>
       <label style="color:#FFF;">Subject</label>
       <input type="text" name="subject" class="form-control"/>
       <label style="color:#FFF;">Key words</label>
       <input type="text" name="keywords" class="form-control"/><br/>
       <select class="form-control" name="dept">
       <%
       ResultSet rs=AppConfig.getDao().getDept();
       while(rs.next()){%>
    	 <option><%=rs.getString(1)%></option>  
      <%  }
       %>
       
       </select>
       
       <label> </label>
       <textarea rows="4" cols="d" class="form-control" name="body"></textarea><br/>
       
       <input type="submit" value="submit" class="btn btn-primary">

      </form>
       
       </div>
        <%}%>
    
          <!-- end of send email -->
          
          
          
           <!-- View  Sent email  -->
        <%
        if(request.getParameter("page").equalsIgnoreCase("sent")){%>
        	    <div class="col-lg-6 order-1 order-lg-2">
         <%
         RegisterModel rm= (RegisterModel)session.getAttribute("account");
         
         List<EmailModel> emails= AppConfig.getEmailService().getEmails(rm.getEmailid(), "sent");
         
         %>
     <table class="table">
     <tr>
     <th>TO</th>
      <th>Subject</th>
       <th>date</th>
       </tr>
						<%
						for (EmailModel em : emails) {
						%>

						<tr>
							<th><%=em.getFromEmail()%></th>
							<th><%=em.getSubject()%></th>
							<th><%=em.getDate()%>
						</tr>

						<%
						}
						%>


					</table>
       
       </div>
        <%}%>
    
          <!-- end of view sent emails -->
          
           <!-- view Inbox email  -->
         <%
        if(request.getParameter("page").equalsIgnoreCase("inbox")){%>
        	    <div class="col-lg-6 order-1 order-lg-2">
         <%
         RegisterModel rm= (RegisterModel)session.getAttribute("account");
         
         List<EmailModel> emails= AppConfig.getEmailService().getEmails(rm.getEmailid(), "inbox");
         
         %>
     <table class="table">
     <tr>
     <th>From</th>
      <th>Subject</th>
       <th>date</th>
       </tr>
						<%
						for (EmailModel em : emails) {
						%>

						<tr>
							<th><%=em.getFromEmail()%></th>
							<th><%=em.getSubject()%></th>
							<th><%=em.getDate()%>
						</tr>

						<%
						}
						%>


					</table>
       
       </div>
        <%}%>
    
          <!-- end of inbox email -->
          
          
             <!-- view search keword email  -->
         <%
        if(request.getParameter("page").equalsIgnoreCase("search")){%>
        	    <div class="col-lg-6 order-1 order-lg-2">
        	    

<!-- Link to open the modal -->

         <%
         RegisterModel rm= (RegisterModel)session.getAttribute("account");
         //System.out.println("email id in search"+rm.getEmailid());
         
        // List<EmailModel> emails= AppConfig.getEmailService().getEmails(rm.getEmailid(), "inbox");
     
         
         %>
         <form action="EmailSearch" method="get">
  <input type="text" class="form-control" name="keyword" placeholder="Enter keywords to search the mails" id="autosearch"><br/>
  <input type="submit" value="SEARCH" class="btn btn-primary">
       </form>
       <%
       if(request.getAttribute("emails")!=null){
       
    	   List<EmailModel> emails=new ArrayList<EmailModel>();
           emails= (List<EmailModel>)request.getAttribute("emails");
       %>
        
        <table class="table">
       <tr><td>Mail Id</td>
       <td>subject</td>
       <td>Date</td>
       </tr>
       <%
       String cssStyle=null;
       for(EmailModel em: emails){
       //System.out.println("emails dept"+em.getDept());
       //System.out.println("register dept"+rm.getDepartment());
    	   if(em.getBody().equalsIgnoreCase(rm.getDepartment())){%>
    	<tr style="color:#FFF;">
    	 <td><%=em.getFromEmail() %></td>
    	 <td><%=em.getSubject() %></td>
    	 <td><%=em.getDate() %></td>
    	 <div id="ex1" class="modal" style="width: 500px; height: 500px;top:100px;left:100px;">
  Team:<p><%=em.getBody()%></p>
  From:<p><%=em.getFromEmail()%></p>
  <%-- Receiver:<p><%=em.getToEmail()%></p> --%>
  Subject:<p><%=em.getSubject()%></p>
  Date:<p><%=em.getDate()%></p>
   Body: <p><%=em.getDept()%></p>
  <a href="#" rel="modal:close">Close</a>
</div>
    	 <td><p><a href="#ex1" rel="modal:open" style="color:#FFFFFF;" class="btn btn-danger">Open Mail</a></p></td>
    	 </tr>
    	   <% }else{%>
    		   <tr style="color:#000;">
    	 <td class="test" style="text:"not accessable""><%=em.getFromEmail() %></td>
    	 <a href=""><td><%=em.getSubject() %></td></a>
    	 <td><%=em.getDate() %></td>
    	 </tr>
    	   <% }
       %>
       
    	 
    	 <%} %>
       
       
       
       
       </table>
       
    	   
       <%}
       %>
      
       
       </div>
       
       
        <%}%>
    
          <!-- end of search keyword email -->
          
          
          
        </div>
      </div>
   
    <div class="icon-boxes position-relative">
      <div class="container position-relative">
        <div class="row gy-4 mt-5">

         

        
        </div>
      </div>
    </div>

   
  </section>
  <!-- End Hero Section -->

  <main id="main">

   
    <!-- ======= Clients Section ======= -->
    <section id="clients" class="clients">
      <div class="container" data-aos="zoom-out">
   
       
      </div>
    </section><!-- End Clients Section -->

   
    </main><!-- End #main -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>