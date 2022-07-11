<div th:fragment="header">
<!doctype html>
<html lang="en">
<head>
<title>Website menu 02</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	th:href='@{https://fonts.googleapis.com/css?family=Roboto:400,100,300,700}'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	th:href="@{https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css}">

<link rel="stylesheet" th:href="@{/admin/css/style.css}">

<link
	th:href="@{https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap}"
	rel="stylesheet">

<link
	th:href="@{https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap}"
	rel="stylesheet">

<link
	th:href="@{https://fonts.googleapis.com/css?family=Source+Serif+Pro:400,600&display=swap}"
	rel="stylesheet">

<link rel="stylesheet" th:href="@{/admin/fonts/icomoon/style.css}">

	<!-- Bootstrap CSS -->
<link rel="stylesheet" th:href="@{/admin/css/bootstrap.min.css}">

	<!-- Style CSS -->
<link rel="stylesheet" th:href="@{/admin/css/style1.css}">

</head>
			<nav
				class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
				id="ftco-navbar">
				<div class="container">

					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#ftco-nav" aria-controls="ftco-nav"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="fa fa-bars"></span> Menu
					</button>
					<div class="collapse navbar-collapse" id="ftco-nav">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" th:href="@{/trang-chu}" id="dropdown04"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"><b>Trang chủ</b></a>
								<div class="dropdown-menu" aria-labelledby="dropdown04">
									<a class="dropdown-item" th:href="@{/trang-chu}"><b>Trang chủ 1</b></a> <a
										class="dropdown-item" th:href="@{trang-chu}">Trang chủ 2</a> <a
										class="dropdown-item" href="#">Trang chủ 3</a> <a
										class="dropdown-item" href="#">Trang chủ 4</a>
								</div></li>
							<li class="nav-item"><a th:href="@{/admin/product}" class="nav-link"><b>Quản lí sản phẩm</b></a></li>
							<li class="nav-item"><a th:href="@{/admin/user}" class="nav-link"><b>Quản lí User</b></a></li>
							<li class="nav-item"><a th:href="@{/admin/categories}" class="nav-link"><b>Quản lí Danh mục</b></a></li>
							<li class="nav-item"><a th:href="@{/admin/blog}" class="nav-link"><b>Quản lí Blog</b></a></li>
							<li class="nav-item"><a href="#" class="nav-link"><b>Quản lí đơn hàng</b></a></li>
							<li class="nav-item"><a th:href="@{/admin/review}" class="nav-link"><b>Quản lí comment</b></a></li>
							<li class="nav-item"><a th:href="@{/logout}" class="nav-link"><b>Đăng xuất</b></a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- END nav -->

		<script th:src="@{/admin/js/jquery.min.js}"></script>
		<script th:src="@{/admin/js/popper.js}"></script>
		<script th:src="@{/admin/js/bootstrap.min.js}"></script>


</body>
</html>
</div>