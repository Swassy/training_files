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
  <li><a href="" id="viewAll">ViewAll</a></li>
  <li><a href="http://localhost:8080/record/search">Search</a></li>
  <li><a href="http://localhost:8080/record/delete">Delete</a></li>
</ul>
</div>
<div id="view-all_container" align="center" style="display:none">
	<div> VIEWING ALL RECORDS</div>
	<div>
		<select id="page_nos"  onchange="retrieveRec(0)" path="page_no">
			<option value=1>Page1
			

			
		</select>
		<select id="contents_per_page" path="contents_per_page" onchange="callRetrieveRec()">
			<option value=5>5
			<!-- <option value=10>10
			<option value=20>20 -->
		</select>
	</div>
	<div id="new1"></div>
	<div><button id="prev">PREV</button><button id="next">NEXT</button></div>
</div>
</body>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">

var max_pg_no;
var tot_cont;
$("#viewAll").click(function()
					{			
						document.getElementById("view-all_container").style.display="inline";
						retrieveRec(1);
						
					});
function retrieveRec( bool)
{
			//document.getElementById("view-all_container").style.display="inline";
	    	
	    	
	    	var json = { "page_no" : Number(document.getElementById("page_nos").value), "contents_per_page" : Number(document.getElementById("contents_per_page").value)};
	    	//alert(json.page_no);//alert=("contents_per_page : "+content_per_page);
			
			
			$.ajax({
				url:"http://localhost:8080/record/viewall",
			  	type: "POST",
			  	data:JSON.stringify(json),
				  	
				  	
			  	beforeSend: function(xhr) {
			  		xhr.setRequestHeader("Accept", "application/json");
			  		xhr.setRequestHeader("Content-Type", "application/json");
			  	},
				  	
			  	success: function(rec) {
			  		
			  		
			  		if(bool===1)
			  		{
			  			tot_cont=rec[0].totalContent;
			  			max_page_content(tot_cont);
			  			
			  			max_pg_no=Math.ceil((rec[0].totalContent)/($("#contents_per_page").val()));
				  		//alert(max_pg_no);
				  		max_page_no(max_pg_no);
				  		
			  		}
			  		
			  	
			  		var len=rec.length;
			  		var respContent = "<table style='border:1px solid;background:#98bf21'><th>NAME</th><th>ROLL</th><th>GENDER</th>";
			  		for(var i=1;i<len;i++){
			  			var str;
			  			if(i&1)str="white";
			  			else str="aqua";
				  		respContent +="<tr style='border:2px solid;background:"+str+"'><td>"+rec[i].name+"</td>";
				  		respContent +="<td style='background:"+str+"'>"+rec[i].roll+"</td>";
				  		respContent +="<td style='background:"+str+"'>"+rec[i].gender+"</td></tr>";
				  		
			  		}
			  		respContent+="</table>";
			  		
			  		
			  		/*var rowToDelete = $(event.target).closest("tr");
			  		
			  		rowToDelete.remove();
			  		
			  		
			  		respContent += "<span class='success'>Smartphone was deleted: [";
			  		respContent += smartphone.producer + " : ";
			  		respContent += smartphone.model + " : " ;
			  		respContent += smartphone.price + "]</span>";*/
			  		
			  		$("#new1").html(respContent);
			  		
			  		
				  		
				  		
			  	},
			  	error: function(){alert("error in ajax");}
			});
	  
			event.preventDefault();
}
			
	    
console.log(max_pg_no);
	
$("#prev").click(function()
				{
					var pg=Number(document.getElementById("page_nos").value);
					if(pg>1)
					{
						pg-=1;
						document.getElementById("page_nos").selectedIndex=pg-1;
						retrieveRec(0);
						//document.getElementById("page_nos").value=pg;
						//retrieveRec(pg,Number($("#contents_per_page").val()));
					}
					//alert(pg);
			
				});
		
$("#next").click(function()
				{
					var pg=Number(document.getElementById("page_nos").value);
					if(pg<(max_pg_no))
					{
						pg+=1;
						document.getElementById("page_nos").selectedIndex=pg-1;
						retrieveRec(0);
						//document.getElementById("page_nos").value=pg;
						//retrieveRec(pg,Number($("#contents_per_page").val()));
					}
					//alert(pg);
				});
			
function callRetrieveRec(){
	//alert("calledRR");
	//var pg=1;
	document.getElementById("page_nos").value=1;
	//var cpp=Number(document.getElementById("contents_per_page").value);
	//alert(cpp);
	//alert(pg,cpp);
	max_pg_no=Math.ceil(tot_cont/($("#contents_per_page").val()));
	alert("enter rr");
	alert(max_pg_no);
	max_page_no(max_pg_no);
	retrieveRec(0);
	
}
function max_page_content(tot_cont)
{
	if(tot_cont>5){
		var str="<option value=5>5<option value=10>10";
		$("#contents_per_page").html(str);
	}
	if(tot_cont>10){
		var str="<option value=5>5<option value=10>10<option value=20>20";
		$("#contents_per_page").html(str);
	}
}
function max_page_no(max_pg_no)	
{
	//alert("inside max_page_no");
	var pgNos="";
	for(var i=1;i<=max_pg_no;i++)
	{
		pgNos+="<option value="+i+">Page-"+i;
	}
	$("#page_nos").html(pgNos);
}
	
	</script>
</html>
