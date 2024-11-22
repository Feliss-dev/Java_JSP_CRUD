package model;

public class Computer {
	private int maMayTinh;
	private String tenMayTinh;
	private String hangSanXuat;
	private int soLuong;
	private double donGia;
	public int getMaMayTinh() {
		return maMayTinh;
	}
	public void setMaMayTinh(int maMayTinh) {
		this.maMayTinh = maMayTinh;
	}
	public String getTenMayTinh() {
		return tenMayTinh;
	}
	public void setTenMayTinh(String tenMayTinh) {
		this.tenMayTinh = tenMayTinh;
	}
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public Computer(int maMayTinh, String tenMayTinh, String hangSanXuat, int soLuong, double donGia) {
		super();
		this.maMayTinh = maMayTinh;
		this.tenMayTinh = tenMayTinh;
		this.hangSanXuat = hangSanXuat;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public Computer(String tenMayTinh, String hangSanXuat, int soLuong, double donGia) {
		super();
		this.tenMayTinh = tenMayTinh;
		this.hangSanXuat = hangSanXuat;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	
}
