<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script th:src="@{https://kit.fontawesome.com/64d58efce2.js}"
	crossorigin="anonymous"></script>
<link rel="stylesheet" th:href="@{/css/style.css}">
<title>Sign in & Sign up Form</title>
</head>
<body>
	<div class="container">
        <script src="https://www.google.com/recaptcha/api.js"></script>
		<div class="forms-container">
			<div class="signin-signup">
				<form th:action="@{/login}" method ="post" class="sign-in-form" id="loginForm">
					<h2 class="title">Đăng nhập</h2>
					<div th:if="${param.error}">
						<p style = "color : red; text-align: center">[[${session.SPRING_SECURITY_LAST_EXCEPTION.message}]]</p>
					</div>

					<div th:if="${param.otp}">
						<p style = "color : red; text-align: center">Kiểm tra mã OTP được gửi tới email [[${param.email}]]</p>
					</div>

					<div th:if="${param.logout}">
						<p style = "color : red; text-align: center"> Bạn vừa mới logout</p>
					</div>
					<div class="input-field">
						<i class="fas fa-user"></i> <input type="Email"
							placeholder="Email" th:value="${param.email}" name="username"/>
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="password"
							th:placeholder="${param.otp != null ? 'Your One Timne Password (OTP)' : 'Password'}" name ="password" />
					</div>
					<button class="g-recaptcha btn btn-primary" data-sitekey="6LfjhogeAAAAAALrESQQ95hwKHI5epNzvQKFCM-v" data-callback="onSubmit" data-action="submit">Đăng nhập</button> <!--class="btn solid" -->
					<p class="social-text">Or Sign in with social platforms</p>
					<div class="social-media">
						<a th:href="@{/oauth2/authorization/facebook}" class="social-icon"> <i class="fab fa-facebook-f"></i>
						</a> <a href="#" class="social-icon"> <i class="fab fa-twitter"></i>
						</a> <a th:href="@{/oauth2/authorization/google}" class="social-icon"> <i class="fab fa-google"></i>
						</a> <a href="#" class="social-icon"> <i
							class="fab fa-linkedin-in"></i>
						</a>
					</div>
				</form>
				<form th:action="@{/dang-nhap}" class="sign-up-form" method = "post">
					<h2 class="title">Đăng ký</h2>
					<div class="input-field">
						<i class="fas fa-user"></i> <input type="text"
							placeholder="Fullname" name = "name"/>
					</div>
					<div class="input-field">
						<i class="fas fa-envelope"></i> <input type="Email"
							placeholder="Email" name = "username"/>
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="password"
							placeholder="Password" name="password" />
					</div>
					<input type="submit" class="btn" value="Sign up" />
					<p class="social-text">Or Sign up with social platforms</p>
					<div class="social-media">
						<a href="#" class="social-icon"> <i class="fab fa-facebook-f"></i>
						</a> <a href="#" class="social-icon"> <i class="fab fa-twitter"></i>
						</a> <a href="#" class="social-icon"> <i class="fab fa-google"></i>
						</a> <a href="#" class="social-icon"> <i
							class="fab fa-linkedin-in"></i>
						</a>
					</div>
				</form>
			</div>
		</div>

		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<h3>New here ?</h3>
					<p>Do you already have an account. If not, click below</p>
					<button class="btn transparent" id="sign-up-btn">Sign up</button>
				</div>
				<img th:src="@{/images/log.svg}" class="image" alt="" />
			</div>
			<div class="panel right-panel">
				<div class="content">
					<h3>One of us ?</h3>
					<p>Do you have an account, if so, please click the button below
						to log in.</p>
					<button class="btn transparent" id="sign-in-btn">Sign in</button>
				</div>
				<img th:src="@{/images/register.svg }" class="image" alt="" />
			</div>
		</div>
	</div>

	<script type="text/javascript" th:src="@{/js/app.js}"></script>

    <script type = "text/javascript">
        function onSubmit(token){
            document.getElementById("loginForm").submit();
        }
    </script>

</body>
</html>
