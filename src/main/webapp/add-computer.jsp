<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
    <title>Thêm máy tính</title>
    <script src="https://cdn.tailwindcss.com"></script>
    
</head>
<body class="bg-gray-100 flex justify-center items-center h-screen my-4">
    <div class="bg-white shadow-lg rounded-lg p-8 w-full max-w-xl ">
        <h2 class="text-2xl font-bold text-center mb-6 text-gray-700">Thêm máy tính</h2>
        <form name="computerForm" action="AddComputer" method="post" class="space-y-4 ">
            <div class="grid grid-cols-2 gap-4">
            <div>
                <label class="block text-gray-600 mb-1">Mã máy tính</label>
                <input type="text" name="maMayTinh" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-200" placeholder="Auto Increment" disabled="disabled">
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Tên máy tính</label>
                <input type="text" name="tenMayTinh" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-200" placeholder="Tên máy tính" required>
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Hãng sản xuất</label>
                <input type="text" name="hangSanXuat" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-200" placeholder="Hãng sản xuất" required>
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Số lượng</label>
                <input type="number" name="soLuong" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-200" placeholder="Số lượng" required>
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Đơn giá</label>
                <input type="number" name="donGia" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-200" placeholder="Đơn giá" required>
            </div>
           
            </div>
            <div class="text-center mt-6">
                <input type="submit" value="Thêm máy tính" class="w-full bg-indigo-500 text-white px-4 py-2 rounded-lg hover:bg-indigo-600 transition duration-200 justify-center">
            </div>
        </form>
    </div>
</body>
</html>
