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
  <li><a href="#">Insert</a></li>
  <li><a href="http://localhost:8080/record/viewall">ViewAll</a></li>
  <li><a href="http://localhost:8080/record/search">Search</a></li>
  <li><a href="http://localhost:8080/record/delete">Delete</a></li>
</ul>
</div>
<div align="center" id="form_container" style="display:inline;">
	<form  method="post"  id="new_record">
		ROLL  NUMBER <input id="roll" name="roll" type="number" min="1">
		<br></br>
		FIRST  NAME  <input id="fname" name="fname" type="text" value="swastik">
		<br></br>
		MIDDLE NAME  <input id="mname" name="mname" type="text" value="harish">
		<br></br>
		LAST   NAME  <input id="lname" name="lname" type="text" value="krishnan">
		<br></br>
		<b>STANDARD</b>
		<br></br>
		CLASS  8<input id="std" name="std" type="radio" value=8 path="std">
		<br></br>
		CLASS 10<input id="std" name="std" type="radio" value=10 path="std">
		<br></br>
		CLASS 12<input id="std" name="std" type="radio" value=12 path="std">
		
		<br></br>
		<b>Gender</b>
		<br></br>
		Male<input id="gender" name="gender" type="checkbox" value="M" path="gender">
		<br></br>
		Female<input id="gender" name="gender" type="checkbox" value="F" path="gender">
		<br></br>
		School<input id="school" name="school" type="text" path="school">
		<br></br>
		Percentage<input id="percentage" name="percentage" type="number" min="30" max="100" path="percentage">%
		<br></br>
		<input type="submit" value="SUBMIT">
	</form>
<!-- <link href="../resources/css/main.css" rel="stylesheet" type="text/css"/> -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    $(document).ready(function() {
      
      $('#new_record').submit(function(event) {
    	  //alert("Hel;lo");    	  
    	  event.preventDefault();
    	  var roll = $('#roll').val();
    	  var name = $('#fname').val()+" "+$('#mname').val()+" "+$('#lname').val();
    	  var std = $('#std').val();
    	  var gender=$("#gender").val();
    	  var school=$("#school").val();
    	  var percentage=$("#percentage").val();
    	  var json = { "roll" : roll, "name" : name, "std": std, "gender": gender, "school": school, "percentage": percentage};
    	  //alert(JSON.stringify(json));
        $.ajax({
        	url:"${pageContext.request.contextPath}/insert",
        	data: JSON.stringify(json),
        	type: "POST",
        	
        	beforeSend: function(xhr) {
        		xhr.setRequestHeader("Accept", "application/json");
        		xhr.setRequestHeader("Content-Type", "application/json");
        	},
        	success: function(studen) {
        		
        		//alert("Inside response");
        		//alert("The returnd response is "+ studen);
        		
        		var respContent = "";
        		alert(studen.length);
		  		/* respContent += "<table style='border:1px solid;background:#98bf21'>";
		  		respContent +="<tr style='border:2px solid;background:white'><td><b>NAME</b></td><td style='background:white'>"+studen[0].name+"</td></tr>";
		  		respContent +="<tr style='border:2px solid;background:white'><td><b>ROLL</b></td><td style='background:white'>"+studen[0].roll+"</td></tr>";
		  		respContent +="<tr style='border:2px solid;background:white'><td><b>GENDER</b></td><td style='background:white'>"+studen[0].gender+"</td></tr>"; */
		  		respContent+="</table>"
        		
        		   		
        	
        	    
        		document.getElementById("new_record").style.display="none";
        		//$("#pagination_div").style.display="block";
        		$("#newDiv").html(respContent);
        },
        	error: function(data) {
        		alert("Error occurred in Ajax Call");
        		console.log(data);
        	}
        });
         
        
      });
       
    });   
  </script>
</div>
<div id="newDiv" align="center"> </div>  
<!-- <div id="pagination_div" ><button id="prev" name="prev">PREV</button><button id="page1" name="page1">1</button><button id="next" name="next">NEXT</button></div> -->
</body>
</html>
