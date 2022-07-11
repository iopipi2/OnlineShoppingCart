<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:th="http://www.thymeleaf.org"></html>
<html>
    <head>
        <title>View Account</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/user.css" />
        <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
        <script src="https://kit.fontawesome.com/069a201b18.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Account Management</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body class="body">
        <div class="container-fluid">
                <h1 style="text-align: left ; color: gainsboro;" class="col-lg-10 mx-auto justify-content-end" >Quản lý hợp đồng</h1>

        <nav class="navbar navbar-light justify-content-between">
            <button class="btn btn-primary btn-xs" data-title="Add" data-toggle="modal" data-target="#modelCreateData"
            type="submit">Create Contract</button>
        <div style="color: white">
            ${message}
        </div>
            <div style="color: red">
                ${message}
            </div>
            <form class="form-inline" th:action="@{/search}" method="GET">
                <input class="form-control mr-sm-2"name="search" type="search" placeholder="Tìm kiếm" aria-label="Tìm kiếm" value="${search}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>

            </form>
        </nav>
        <table id="datatable" class="table table-striped table-bordered mx-auto" cellspacing="0" width="70%">
            <tr>
              <th>ID Contract</th>
              <th>Product Name</th>
              <th>User Name</th>
              <th>Ngày mua bảo hiểm </th>
              <th>Thời hạn hợp đồng</th>
              <th>Trạng thái hợp đồng</th>
              <th>Thao tác</th>

            </tr>

            <c:forEach var="conn" items="${Contracts}">
                <tr>
                    <td>${conn.contract_id}</td>
                    <td>${conn.prostring}</td>
                    <td>${conn.userstring}</td>
                    <td>${conn.contract_date}</td>
                    <td>${conn.contract_time}</td>


                    <td>${conn.status}</td>

                    <td>
                        <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal"
                            data-target="#view${conn.contract_id}"> <a>Detail</a>
                            <i class="fa-solid fa-eye"></i>
                        </button>
                        <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit${conn.contract_id}"> <a
                                style="color:white ;" href="/editContract?id=${conn.contract_id}">Edit</a>
                            <i class="fa-solid fa-pen"></i>
                        </button>
                        <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete${conn.contract_id}">
                            <a>Delete</a>
                            <i class="fa-solid fa-trash-can"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>


        </table>


    <script>

                var menuBtn = document.getElementById("menuBtn");
                var sideNav = document.getElementById("sideNav");
                var menu = document.getElementById("menu");
                sideNav.style.right = "-250px";
                menuBtn.onclick = function () {
                    if (sideNav.style.right == "-250px") {
                        sideNav.style.right = "0";
                        menu.src = "IMG/close.png";
                    } else {
                        sideNav.style.right = "-250px";
                        menu.src = "IMG/menu.png";
                    }
                }

                var scroll = new SmoothScroll('a[href*="#"]', {
                    speed: 1000,
                    speedAsDuration: true
                });

            </script>
    </body>
</html>