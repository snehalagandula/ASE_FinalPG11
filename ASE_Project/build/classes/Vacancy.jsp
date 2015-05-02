<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<style type="text/css">
*{
	margin: 0 auto 0 auto;
	text-align:left;
}

body{
	margin:0;
	padding:0;
	text-align:left;
	font-size:13px;
	font-family:arial,helvetica, sens-serif;
	color:#000000;
	background-color:#2A93CF;
	background-image:url(/images/background.png);
	background-repeat:repeat-x;
	
}
#1c478e

a{
	text-decoration:none;
}

table,tr,td,th{
	margin:0;
}

table{
	padding:10px 0;
}

th{
	text-align:center;
}

td{
	padding:5px 20px;
}

h2{
	padding-bottom:10px;
}

h3{
	font-size:16px;
	font-weight:bold;
	padding:10px 0;
	color:#054dbc;
}

h4{
	font-size:15px;
	font-weight:bold;
	padding-bottom:7px;
	color:#054dbc;
}

p{
	margin:10px 0;
}

label{
	display:inline-block;
	width:150px;
}

/* Main styles */
#container{
	width:960px;
	overflow:auto;
}

header{
	width:960px;
	height:85px;
}

header h1{
	float:left;
	color:#ffffff;
	font-size:43px;
	padding:20px 0 0 20px;
}

header h2{
	float:right;
	color:#A9D1FA;
	padding:40px 20px 0 0;
}

header h1 span.blue-text{
	color:#67A0F5;
}

header h2 span.white-text{
	color:#ffffff;
}

aside{
	color:#fff;
}
aside input[type="text"],aside input[type="email"]{
	color:#000;
	margin-bottom:5px;
}

#displayname{
	float:right;
	color:#fff;
	font-weight:bold;
	font-size:16px;
}

nav#menu{
	display:block;
	float:left;
	clear:both;
	width:960px;
	height:54px;
	background-color: #2255AA;
	
}

nav#menu ul{
	list-style:none;
	padding:0;
	padding-top:18px;
	margin-left:auto;
	width:960px;
}

nav#menu li{
	list-style:none;
	padding:0;
	display;inline;
}

nav#menu li a,#menu li a:visited{
	float:left;
	color:#ffffff;
	text-decoration:none;
	text-align:center;
	font-size:15px;
	font-weight:bold;
	padding:0 13px 0 13px;
}

nav#leftmenu{
	margin-top:15px;
	width:190px;
	float:left;
	background:#2255AA;
	border-radius:10px;
	padding: 15px 20px 10px 10px;
}

nav#leftmenu ul{
	list-style:none;
	padding:0;
}

nav#leftmenu  li{
	list-style:none;
	padding:15px 0 8px 0;
	border-bottom:1px dashed #fff;
}

nav#leftmenu a,nav#leftmenu a:visited{
	color:#ffffff;
	text-decoration:none;
	font-weight:bold;
	font-size:14px;
}

nav#leftmenu h3{
	color:#ffffff;
	padding:0;
	padding-bottom:8px;
	border-bottom:#fff solid 2px;
	font-size:16px;
}

section{
	display:block;
	width:680px;
	margin-top:15px;
	float:left;
	background:#ffffff;
	border-radius:10px;
	border:6px solid #1C478E;
	padding:15px;
	margin-left:15px;
	height:435px;
}

.float{
	float:right;
	margin:15px;
}

.developer{
	width:220px;
	float:left;
}

.developer ul{
	margin-bottom:10px;
	list-style:none;
	padding:0;
}

.developer li{
	list-style:none;
	line-height:1.7em;
}

table.dev-table,table.dev-table tr,table.dev-table td,table.dev-table th{
	font-size:110%;
}
dev-table tr,table.dev-table td{
	border-bottom: 1px dashed #000000;
}

footer{
	width:100%;
	background:#000;
	color:#fff;
	height:30px;
	text-align:center;
	margin-top:20px;
	padding-top:15px;
}


#1c478e</style>
<title>Student Accommodation</title>
<script type="text/javascript">
function initStorage(){
	function saveName(){
		var name = document.getElementById('name');
		localStorage.setItem('name',name.value);
	}
	
	function saveEmail(){
		var email = document.getElementById('email');
		localStorage.setItem('email',email.value);
	}
	
	//Run functions
	saveName();
	saveEmail();
}

<!--function displayName(){	
	if(localStorage.getItem('name') != null){
		document.write('Welcome Back, '+localStorage.getItem('name'));
	}
}-->
	
function showText(){
	if(localStorage.getItem('email') == null){
		document.write('<p>Please enter your email address</p>');
	} else {
		document.write('<p><strong>Subscribed Email:</strong> '+localStorage.getItem('email')+'</p> ');
	}
}

function clearAll(){
	localStorage.clear();   
	window.location.reload()
}
</script>
</head>
<body>
	<div id="container">
		<header>
			<h1><span class="blue-text"></span>Student Accommodation</h1>
			<h2>Find an accommodation <span class="white-text">NOW</span></h2>
		</header>
		
		<nav id="menu">
			<ul>
				<li class="menuitem"><a href="MainPage.html">Home</a></li>
				<li class="menuitem"><a href="about.html">About Us</a></li>
				<li class="menuitem"><a href="StudentLogin.html">Student Login</a></li>
				<li class="menuitem"><a href="AdminLogin.html">Administrator Login</a></li>
								
				<!--  <li class="menuitem"><a href="browse.html">Browse Developers</a></li>-->
				  <li class="menuitem"><a href="map1.html">Route Map</a></li>
				<li class="menuitem"><a href="Contact.html">Contact Us</a></li>
				<li class="menuitem"><a href="API.html">FBShare</a></li>
				<li class="menuitem"><a href="twitterAPI.html">TwitterShare</a></li>
			</ul>
			<div id="displayname">
				<script type="text/javascript">
					displayName();
				</script>
			</div>
	    </nav>
		 
		 <aside>
			<nav id="leftmenu">
			<h3>Links</h3>
				<ul>
					<li><a href="location.html">Locations</a></li>
					<li><a href="Weather.html">Weather</a></li>
					<li><a href="rent.html">Rent Information</a></li>
					<!-- <li><a href="browse.html">Types of Houses</a></li>-->
					<li><a href="parking.html">Parking Details</a></li>
					<li><a href="maintainance.html">Maintainance</a></li>
					<li><a href="postal.html">Postal Services</a></li>
					<!--<li><a href="browse.html">Insurance</a></li>-->
					<li><a href="pets.html">Pets Allowance</a></li>
				</ul>
				
				<div>
				<br><br>
				  <h3>Newsletter</h3>
				<script type="text/javascript">
					showText();
				</script>
				<form id="news" onsubmit="initStorage()">
					Name: <input type="text" id="name" name="name">
					Email: <input type="email" id="email" name="email">
					<input type="submit" value="Send">
					<!--  <a href="#" onClick="clearAll()">Clear</a>-->
				</form>
			</div>
			</nav>
	
		</aside>
    
		 
		 
    
<section>
</head>

<body>


<h3><center>Nearby Apartments Based On Search<center></center></h3>
<br>
<br>

<table border="1" id="details" align="center">
<tr>
<th width="10%">Checkbox</th>
<th width="25%">Apartment</th>
<th width="30%">Address</th>
<th width="10%">Zipcode</th>
<th width="20%">Contact</th>
<th width="10%">Email</th>


</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/test";
String username="root";
String password="admin";
String apt=request.getParameter("dropdwn");

String address=request.getParameter("address");
String code=request.getParameter("code");

//String query="SELECT * FROM hospital  where agegroup ='"+age+"' && service='"+service+"' ORDER BY ABS(ABS(lat-53.23) + ABS(lon-43.23)) ASC LIMIT 10";
String query="select * from vacancy ";


{
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
    
    <tr>
    <td><input type="checkbox"/></td>
    <td width="5%"><%=rs.getString("apt") %></td>
    <td width="30%"><%=rs.getString("address")%></td>
    <td><%=rs.getString("zip")%></td>
    <td><%=rs.getString("phnum") %></td>
    <td><%=rs.getString("eadd")%></td>
    
    </tr>
    
<%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
}

catch(Exception e)
{
    e.printStackTrace();
    }

%>
<br>
<br>
<center>


<form action="Mail.html">
<input type="submit" value="Send an email to book the apartment" id="search" onclick = "validate()" style="padding:5px 17px; background-color:#2255AA;color:#fff;font-weight: bold; border:0 none;cursor:pointer;-webkit-border-radius: 5px;border-radius: 5px;"  ></h2>

</form>

</center>
</div>
<div style="clear;both"></div>
	<footer>
		Copyright &copy; 2015, Student Accommodation
	</footer>

</body>
</html>
