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
  <li><a href="#">ViewAll</a></li>
  <li><a href="http://localhost:8080/record/search">Search</a></li>
  <li><a href="http://localhost:8080/record/delete">Delete</a></li>
</ul>
</div>
<div align="center" >
	<div id="new_container"></div>
	<div align="center">
		<button id="prev" >PREV</button>
		<div id="var_button_container"></div>
		<button id="next" >NEXT</button>
	</div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    window.load=(function() {
    	alert("hellllooooo");
    	var page_no=1;
    	$("#page_1").style.background="blue";
    	var contents_per_page=$("#contents_per_page").val();
    	var json = { "page_no" : page_no, "contents_per_page" : contents_per_page};
    	
		alert(JSON.stringify(json));
			$.ajax({
				url:"${pageContext.request.contextPath}/viewall",
			  	type: "GET",
			  	data:JSON.stringify(json),
			  	//dataType:JSON.stringify(String),
			  	
			  	beforeSend: function(xhr) {
			  		xhr.setRequestHeader("Accept", "application/json");
			  		xhr.setRequestHeader("Content-Type", "application/json");
			  	},
			  	
			  	success: function(rec) {
			  		alert(rec[0]);
			  		
			  		
			  		$("#new_container").html(newresponse);
			  		
			  		
			  		//var respContent = "";
			  		/*var rowToDelete = $(event.target).closest("tr");
			  		
			  		rowToDelete.remove();
			  		
			  		
			  		respContent += "<span class='success'>Smartphone was deleted: [";
			  		respContent += smartphone.producer + " : ";
			  		respContent += smartphone.model + " : " ;
			  		respContent += smartphone.price + "]</span>";
			  		
			  		$("#sPhoneFromResponse").html(respContent);*/
			  		
			  		
			  		
			  		
			  	}
			});
  
			event.preventDefault();
		});
       
  
</script>

</body>
</html>
