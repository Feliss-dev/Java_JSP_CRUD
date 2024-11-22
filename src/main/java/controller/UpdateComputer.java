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
 * Servlet implementation class UpdateComputer
 */
@WebServlet("/UpdateComputer")
public class UpdateComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComputer() {
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
		try {
            // Lấy dữ liệu từ form
			int maMayTinh = Integer.parseInt(request.getParameter("maMayTinh"));
			String tenMayTinh = request.getParameter("tenMayTinh");
	        String hangSanXuat = request.getParameter("hangSanXuat");
	        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
	        double donGia = Double.parseDouble(request.getParameter("donGia"));
	       
	        
	        Computer computer = new Computer(maMayTinh,tenMayTinh, hangSanXuat, soLuong, donGia);
	        ComputerDAO computerDAO = new ComputerDAO();
	        computerDAO.updateComputer(computer);

	       

	        // Chuyển hướng đến danh sách sinh viên sau khi thêm
	        response.sendRedirect("ShowComputer");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle error - perhaps redirect to an error page or show a message
        }
	}

}
