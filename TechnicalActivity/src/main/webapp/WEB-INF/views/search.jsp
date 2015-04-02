<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">      
<title>Search nth Maximum Number using ajax</title>      
          
  <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
             
 <script src="<c:url value="resources/js/jquery.js" />"></script>
 <script type="text/javascript">
 var contexPath = "<%=request.getContextPath() %>";
</script> 
 <script src="<c:url value="resources/js/search.js" />"></script>

</head>
<body>
<h1>
	Search Nth Maximum Number
</h1>	
	
	<fieldset class = "RoundedMargin"">
		<legend> Search</legend>	
			<div> (All fields marked in <span style="color:red;">*</span> are mandatory)</div>
			<div> 
				<label>Enter semicolon seperated list of numbers <span style="color:red;">*</span></label> 
				<input type="text" name="inputList" id ="inputList" value="" class="RoundedMargin" />	
			</div>
			<div>		
				<label>Enter Nth max number to find <span style="color:red;">*</span> </label> 
				<input type="text" name="number" id ="number" class="RoundedMargin" value="" />			
			</div>
			<div align="center">
				<input type ="button" value="Search" class = "SubmitButton" onClick="searchNumber();" />
			</div>
	</fieldset>   	
	<div id="successResult" class="SuccessMessageDiv"> </div>
	<div id="error" class="ErrorMessageDiv"></div>
</body>
</html>
