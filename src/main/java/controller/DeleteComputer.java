package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComputerDAO;

/**
 * Servlet implementation class DeleteComputer
 */
@WebServlet("/DeleteComputer")
public class DeleteComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteComputer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int maMayTinh = Integer.parseInt(request.getParameter("maMayTinh"));

            // Xóa máy tính khỏi cơ sở dữ liệu
            ComputerDAO computerDAO = new ComputerDAO();
            computerDAO.deleteComputer(maMayTinh);

            // Lưu thông báo thành công vào request
            request.setAttribute("successMessage", "Xóa máy tính thành công!");
        } catch (Exception e) {
            // Lưu thông báo lỗi nếu có ngoại lệ
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi xóa máy tính!");
        }

        // Chuyển hướng đến danh sách sinh viên sau khi xóa
        response.sendRedirect("ShowComputer");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
