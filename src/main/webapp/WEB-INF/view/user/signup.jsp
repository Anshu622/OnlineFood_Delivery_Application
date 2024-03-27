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
			<form:form action="/user/addUser" method="post" modelAttribute="user">
			  <div class="form-group">
				<label for="firstName">First Name</label>
				<form:input path="firstName" class="form-control" id="firstName"/>
			  </div>
	  
			  <div class="form-group">
				<label for="lastName">Last Name</label>
				<form:input path="lastName" class="form-control" id="lastName"/>
			  </div>

			  <div class="form-group">
				<label for="email">E-mail</label>
				<form:input path="email" class="form-control" id="email" type="email"/>
			  </div>

              <div class="form-group">
				<label for="age">Age</label>
				<form:input path="age" class="form-control" id="age"/>
			  </div>
              <div class="form-group">
				<label for="gender">Gender</label>
				<form:input path="gender" class="form-control" id="gender"/>
			  </div>
              <div class="form-group">
				<label for="mobileNumber">Mobile Number</label>
				<form:input path="mobileNumber" class="form-control" id="mobileNumber"/>
			  </div>
              <div class="form-group">
				<label for="buildingName">Building Name</label>
				<form:input path="address.buildingName" class="form-control" id="buildingName"/>
			  </div>
	  
			  <div class="form-group">
				<label for="streetNo">Street Number</label>
				<form:input path="address.streetNo" class="form-control" id="streetNo"/>
			  </div>

			  <div class="form-group">
				<label for="city">City</label>
				<form:input path="address.city" class="form-control" id="city"/>
			  </div>

              <div class="form-group">
				<label for="state">State</label>
				<form:input path="address.state" class="form-control" id="state"/>
			  </div>
              <div class="form-group">
				<label for="country">Country</label>
				<form:input path="address.country" class="form-control" id="country"/>
			  </div>
              <div class="form-group">
				<label for="pincode">Pincode</label>
				<form:input path="address.pincode" class="form-control" id="pincode"/>
			  </div>
              <div class="form-group">
				<label for="password">Set Password</label>
				<form:input path="password" class="form-control" id="password" type="password"/>
			  </div>
			  <div class="form-group">
				<button class="btn btn-primary">Sign Up</button>
			  </div>
	  
			</form:form>
		  </div>
	</div>
    
</body>
</html>