<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
    <title>Cập nhật máy tính</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-indigo-900 via-purple-800 to-pink-600 flex justify-center items-center h-screen">
    <div class="bg-white shadow-lg rounded-lg p-8 w-full max-w-md ">
        <h2 class="text-3xl font-bold text-center mb-6 text-gray-800">Cập nhật máy tính</h2>
        <form action="UpdateComputer" method="post" class="space-y-4c ">
            <div class="grid grid-cols-2 gap-4">
            <div>
                <label class="block text-gray-600 mb-1">Mã máy tính</label>
                <input type="number" name="maMayTinh" value="${param.maMayTinh}" readonly class="w-full px-3 py-2 bg-gray-200 rounded-lg" placeholder="Mã máy">
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Tên máy tính</label>
                <input type="text" name="tenMayTinh" value="${param.tenMayTinh}" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-300" placeholder="Tên máy" required>
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Hãng sản xuất</label>
                <input type="text" name="hangSanXuat" value="${param.hangSanXuat}" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-300" placeholder="Hãng" required>
            </div>
            <div>
                <label class="block text-gray-600 mb-1">Số lượng</label>
                <input type="number" name="soLuong" value="${param.soLuong}" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-300" placeholder="Số lượng" required>
            </div>
            
            <div>
                <label class="block text-gray-600 mb-1">Đơn giá</label>
                <input type="number" name="donGia" value="${param.donGia}" class="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring focus:ring-indigo-300" placeholder="Đơn giá" required>
            </div>
           
            </div>
            <div class="text-center mt-6">
                <input type="submit" value="Cập Nhật" class="w-full bg-gradient-to-r from-green-400 to-blue-500 text-white px-4 py-2 rounded-lg hover:bg-gradient-to-l transition duration-200">
            </div>
        </form>
    </div>
</body>
</html>
