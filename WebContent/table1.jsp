<html>  
<head>  

<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
	<script src="assets/js/app-ajax.js" type="text/javascript"></script>
	<script src="assets/js/autocomplete.js" type="text/javascript"></script>
<script>  

var request;  
function sendInfo()  
{  
var v=document.vinform.t1.value;  
var url="test.jsp?val="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try  
{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}  
catch(e)  
{  
alert("Unable to connect to server");  
}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('amit').innerHTML=val;  
}  
}  
  
</script>  
</head>  
<body>  
    <marquee><h1>This is an example of ajax</h1></marquee>  
<form name="vinform">  
<input type="text" name="t1">  
<input type="button" value="ShowTable" onClick="sendInfo()">  
</form>  
  
<span id="amit"> </span>  

<form>
		Enter Your Name: <input type="text" id="userName" />
	</form>
	<br>
	<br>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
  
</body>  
</html>  