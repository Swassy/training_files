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
  <li><a href="http://localhost:8080/record/insert">Insert</a></li>
  <li><a href="http://localhost:8080/record/viewall">ViewAll</a></li>
  <li><a href="#">Search</a></li>
  <li><a href="http://localhost:8080/record/delete">Delete</a></li>
</ul>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	   
	  $('#newSmartphoneForm').submit(function(event) {
	       
	      var producer = $('#producer').val();
	      var model = $('#model').val();
	      var price = $('#price').val();
	      var json = { "producer" : producer, "model" : model, "price": price};
	       
	    $.ajax({
	        url:"jdbc:mysql://localhost:3306/tests",// $("#newSmartphoneForm").attr( "action"),
	        dataType: JSON.stringify(json),
	        type: "POST",
	         
	        /*beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },*/
	        success: function(smartphone) {
	            var respContent = "";
	             
	            respContent += "<span class='success'>Smartphone was created: [";
	            respContent += stud.name + " : ";
	            respContent += stud.roll + " : " ;
	            respContent += stud.percentage + "]</span>";
	             
	            $("#sPhoneFromResponse").html(respContent);        
	        }
	    });
	      
	    event.preventDefault();
	  });
	    
	});
</script>
</html>
