<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<!DOCTYPE html>
<html lang="en"><!-- Basic -->
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Site Metas -->
    <title>Live Dinner Restaurant - Responsive Template</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="../../images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">    
	<!-- Site CSS -->
    <link rel="stylesheet" href="../../css/style.css">    
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="../../css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="../../css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

						
	

	<div class="container" style="margin-top: 0px;margin-bottom: 80px;padding: 20px;height: 100px;">
		<div class="row">
			<form:form action="/login/adminlogin" method="post" modelAttribute="login">
			  <div class="form-group">
				<label for="email">email</label>
				<form:input path="email" class="form-control" id="email"/>
			  </div>
				
              <div class="form-group">
				<label for="passWord">Password</label>
				<form:input path="passWord" class="form-control" id="passWord"/>
			  </div>

			  <div class="form-group">
				<button class="btn btn-primary" style="margin-left: 10%; margin-bottom: 2%;">Login</button>
			  </div>
	  
			</form:form>
		  </div>
	</div>
    
</body>
</html>