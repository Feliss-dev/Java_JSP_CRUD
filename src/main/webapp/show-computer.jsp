<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>

    <meta charset="UTF-8">
    <title>Danh sách máy tính</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
    
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            background-color: #ffffff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 2rem;
            border-radius: 8px;
        }
        h3 {
            color: #343a40;
            font-weight: bold;
            margin-bottom: 1rem;
        }
        .btn-custom {
            border-radius: 20px;
            font-weight: bold;
        }
        table th, table td {
            text-align: center;
            vertical-align: middle;
        }
        .table-wrapper {
            overflow-x: auto;
        }
    </style>
</head>
<body onload="paginate()">
    <div class="container mt-5">
        <h3 class="text-center">Danh sách máy tính</h3>
        
      
		<form action="ShowComputer" method="get">
    <div class="row mb-3">
        <div class="col">
            <input type="text" name="searchName" class="form-control" placeholder="Tìm kiếm theo tên máy tính">
        </div>
        <div class="col">
            <select name="filterBrand" class="form-control">
                <option value="">Chọn hãng sản xuất</option>
                <option value="HP">HP</option>
                <option value="Dell">Dell</option>
                <option value="Asus">Asus</option>
                <option value="Lenovo">Lenovo</option>
                <!-- Thêm các hãng sản xuất khác nếu cần -->
            </select>
        </div>
        <div class="col">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </div>
    </div>
</form>
   <!-- Thông báo thành công -->
<c:if test="${not empty successMessage}">
    <div class="alert alert-success text-center">
        <c:out value="${successMessage}"/>
    </div>
</c:if>

<!-- Thông báo lỗi -->
<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger text-center">
        <c:out value="${errorMessage}"/>
    </div>
</c:if>

<!-- Thông báo thông tin -->
<c:if test="${not empty infoMessage}">
    <div class="alert alert-info text-center">
        <c:out value="${infoMessage}"/>
    </div>
</c:if>

        <!-- Bảng danh sách sách -->
        <div class="table-wrapper">
            <table class="table table-striped table-hover table-bordered">
            
                <thead class="table-dark">
                    <tr>
                        <th>Mã máy tính </th>
                        <th>Tên máy tính</th>
                        <th>Hãng sản xuất</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th colspan="2">Chức năng</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach var="computer" items="${listComputer}">
                        <tr>
                            <td><c:out value="${computer.maMayTinh}"/></td>
                            <td><c:out value="${computer.tenMayTinh}"/></td>
                            <td><c:out value="${computer.hangSanXuat}"/></td>
                            <td><c:out value="${computer.soLuong}"/></td>
                            <td><c:out value="${computer.donGia}"/></td>
                            
                           <td>
    						<a class="btn btn-info btn-sm btn-custom" 
       			href="update-computer.jsp?maMayTinh=${computer.maMayTinh}&tenMayTinh=${computer.tenMayTinh}&hangSanXuat=${computer.hangSanXuat}&soLuong=${computer.soLuong}&donGia=${computer.donGia}">Sửa</a>
				</td>

                            <td>
                                <a class="btn btn-danger btn-sm btn-custom" href="DeleteComputer?maMayTinh=${computer.maMayTinh}">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Phân trang -->
        <div id="pagination" class="mt-3 text-center"></div>

        <!-- Nút thêm sách -->
        <div class="text-center mt-4">
            <a href="add-computer.jsp" class="btn btn-primary btn-custom">Thêm máy tính</a>
        </div>
    </div>

    <script type="text/javascript">
       
        var currentPage = 1;
        var itemsPerPage = 5;

        function paginate() {
            var rows = document.querySelectorAll("tbody tr");
            var totalItems = rows.length;
            var totalPages = Math.ceil(totalItems / itemsPerPage);

            document.getElementById("pagination").innerHTML = "";
            for (let i = 1; i <= totalPages; i++) {
                let button = document.createElement("button");
                button.innerText = i;
                button.className = "btn btn-outline-primary mx-1";
                button.onclick = function () {
                    displayPage(i);
                };
                document.getElementById("pagination").appendChild(button);
            }
            displayPage(currentPage);
        }

        function displayPage(page) {
            var rows = document.querySelectorAll("tbody tr");
            var start = (page - 1) * itemsPerPage;
            var end = start + itemsPerPage;

            rows.forEach((row, index) => {
                row.style.display = (index >= start && index < end) ? "" : "none";
            });
            currentPage = page;
        }
    </script>
</body>
</html>
