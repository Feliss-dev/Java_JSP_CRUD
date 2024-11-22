package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Computer;



public class ComputerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/QuanLySach";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public ComputerDAO() {
		
	}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
 
    private static final String SELECT_ALL_COMPUTER = "SELECT * FROM MayTinh";

    public List<Computer> selectAllComputer() {
        List<Computer> computerList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPUTER)) {
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
               
                int maMayTinh = rs.getInt("MaMayTinh");
                String tenMayTinh = rs.getString("TenMayTinh");
                String hangSanXuat = rs.getString("HangSanXuat");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGia");
                computerList.add(new Computer(maMayTinh, tenMayTinh, hangSanXuat, soLuong, donGia));

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computerList;
    }
    
    public void addComputer(Computer computer) {
	    String query = "INSERT INTO MayTinh (TenMayTinh, HangSanXuat, SoLuong, DonGia) VALUES ( ?, ?, ?, ?)";
	    try (Connection connection = getConnection(); 
	    	PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	        preparedStatement.setString(1, computer.getTenMayTinh());
	        preparedStatement.setString(2, computer.getHangSanXuat());
	        preparedStatement.setInt(3, computer.getSoLuong());
	        preparedStatement.setDouble(4, computer.getDonGia());
	       
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    public void updateComputer(Computer computer) {
	    String query = "UPDATE MayTinh SET TenMayTinh = ?, HangSanXuat = ?, SoLuong = ?, DonGia = ? WHERE MaMayTinh = ?";
	    try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    	 
	    	preparedStatement.setString(1, computer.getTenMayTinh());
	        preparedStatement.setString(2, computer.getHangSanXuat());
	        preparedStatement.setInt(3, computer.getSoLuong());
	        preparedStatement.setDouble(4, computer.getDonGia());
	        preparedStatement.setInt(5, computer.getMaMayTinh());
	        
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteComputer(int maMayTinh) {
	    String query = "DELETE FROM MayTinh WHERE MaMayTinh = ?";
	    try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setInt(1, maMayTinh);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<Computer> searchComputerByName(String name){
		List<Computer> computerList = new ArrayList<Computer>();
		String query = "SELECT * FROM MayTinh WHERE TenMayTinh LIKE ?";
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int maMayTinh = rs.getInt("MaMayTinh");
				String tenMayTinh = rs.getString("TenMayTinh");
	            String hangSanXuat = rs.getString("HangSanXuat");
	            int soLuong = rs.getInt("SoLuong");
	            double donGia = rs.getDouble("DonGia");
	            computerList.add(new Computer(maMayTinh, tenMayTinh, hangSanXuat, soLuong, donGia));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
 		return computerList;
	}
	
	public List<Computer> filterComputerByBrand(String brand){
		List<Computer> computerList = new ArrayList<Computer>();
		
		String query = "SELECT * FROM MayTinh WHERE HangSanXuat = ?";
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
				
			preparedStatement.setString(1, brand);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				  int maMayTinh = rs.getInt("MaMayTinh");
		            String tenMayTinh = rs.getString("TenMayTinh");
		            String hangSanXuat = rs.getString("HangSanXuat");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");
		            computerList.add(new Computer(maMayTinh, tenMayTinh, hangSanXuat, soLuong, donGia));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return computerList;
	}
	
	
	
}
