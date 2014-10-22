<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> -->
<html >
<head>
<style>
ul {
    list-style-type: none;
    margin: 10;
    padding: 10;
    overflow: hidden;
    align: center
}

li {
    float:left;
}

a:link, a:visited {
    display: block;
    width: 250px;
    font-weight: bold;
    color: #FFFFFF;
    background-color: #98bf21;
    text-align:center;
    padding: 4px;
    text-decoration: none;
    text-transform: uppercase;
}

a:hover, a:active {
    background-color: #7A991A;
    font-size: 120%
}
#school_name,#place{
	color:white;
    font-family:Courier New;
    font-weight:500;
    font-size: 200%; 	
}
</style>
<title>St.Xavier's Burdwan</title>
<div align="center">
<h1 id="school_name"><b>ST. XAVIER'S SCHOOL</b></h1>

<h2 id="place">Burdwan</h2>
</div>
</head>
<body bgcolor="grey">
<div align="center" >

<ul>
  <li><a href="http://localhost:8080/record/">Home</a></li>
  <li><a href="http://localhost:8080/record/insertForm" inactive>Insert</a></li>
  <li><a href="http://localhost:8080/record/viewall" inactive>ViewAll</a></li>
  <li><a href="http://localhost:8080/record/search" inactive>Search</a></li>
  <li><a href="http://localhost:8080/record/delete" inactive>Delete</a></li>
</ul>
</div>
The record for ${name} with Roll No :- ${roll} of standard ${std} has been added 
Thank you 
</body>
</html>
