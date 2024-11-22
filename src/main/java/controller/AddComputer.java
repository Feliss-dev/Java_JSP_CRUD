package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComputerDAO;

import model.Computer;


/**
 * Servlet implementation class AddComputer
 */
@WebServlet("/AddComputer")
public class AddComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComputer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lấy dữ liệu từ form
        //int ma_sach = Integer.parseInt(request.getParameter("ma_sach"));
        String tenMayTinh = request.getParameter("tenMayTinh");
        String hangSanXuat = request.getParameter("hangSanXuat");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        double donGia = Double.parseDouble(request.getParameter("donGia"));
        
        Computer computer = new Computer(tenMayTinh, hangSanXuat, soLuong, donGia);
        ComputerDAO computerDAO = new ComputerDAO();
        
        try {
            // Thêm máy tính vào cơ sở dữ liệu
            computerDAO.addComputer(computer);
            // Lưu thông báo thành công vào request
            request.setAttribute("successMessage", "Thêm máy tính thành công!");
        } catch (Exception e) {
            // Lưu thông báo lỗi nếu có ngoại lệ
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi thêm máy tính!");
        }

       

        // Chuyển hướng đến danh sách sinh viên sau khi thêm
        response.sendRedirect("ShowComputer");
	}

}
