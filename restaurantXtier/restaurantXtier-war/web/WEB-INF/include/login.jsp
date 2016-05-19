<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>  
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/login.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  </head>
  <body>
 	<div class="login-form-1">
		<form id="login-form" class="text-left" method="post" action="index?section=login">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
                                                <label for="lg_password" class="sr-only">Mot de passe:</label>
						<input type="password" class="form-control" id="lg_password" name="lg_password" placeholder="">
					</div>
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
		</form>
	</div>
     <script src="js/login.js"></script> 
  </body>
</html>
