package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComputerDAO;
import model.Computer;


/**
 * Servlet implementation class ShowComputer
 */
@WebServlet("/ShowComputer")
public class ShowComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ComputerDAO computerDAO;
	
	public void init() {
		computerDAO = new ComputerDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowComputer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	       
	        String searchName = request.getParameter("searchName");
	        String filterBrand = request.getParameter("filterBrand");
	        
	        List<Computer> listComputer = new ArrayList<Computer>();
	        String message = "";
	        
	        try {
	        	if(searchName != null && !searchName.isEmpty()) {
		        	listComputer = computerDAO.searchComputerByName(searchName);
		        	message = "Tìm kiếm thành công!";
		            request.setAttribute("successMessage", message); // Lưu thông báo thành công
		        	
		        }else if(filterBrand != null && !filterBrand.isEmpty()) {
		        	listComputer = computerDAO.filterComputerByBrand(filterBrand);
		        	 message = "Lọc máy tính theo hãng thành công!";
		             request.setAttribute("successMessage", message); // Lưu thông báo thành công
		        }else {
		        	listComputer = computerDAO.selectAllComputer();
		        	message = "Hiển thị tất cả máy tính!";
		            request.setAttribute("infoMessage", message); // Lưu thông báo thông tin
		        }
	        	
	        	
			} catch (Exception e) {
				// TODO: handle exception
				message = "Có lỗi xảy ra";
				request.setAttribute("errorMessage", message); // Lưu thông báo lỗi
				e.printStackTrace();
			}
	        
	        
	        
	        request.setAttribute("listComputer", listComputer);
	        request.setAttribute("message", message);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("show-computer.jsp");
	        dispatcher.forward(request, response);
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
