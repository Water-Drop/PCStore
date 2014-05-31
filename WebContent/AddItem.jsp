<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body onload="internationalization()">
	<script src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript">
		function internationalization() {
			var language = document.getElementById("language").value;
			$.get("AddItem",
				    {
			          language:language
				    },
				    function(data,status){
				    	document.getElementById("additemdiv").innerHTML="";
				    	document.getElementById("additemdiv").innerHTML=data;
				    });
		}
	</script>
	<select id="language" onchange="internationalization()">
		<option value="en" selected>English</option>
		<option value="zh">中文</option>
	</select>
<div id=additemdiv></div>
</body>
</html>