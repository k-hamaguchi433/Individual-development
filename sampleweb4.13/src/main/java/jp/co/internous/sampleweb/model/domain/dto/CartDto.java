package jp.co.internous.sampleweb.model.domain.dto;
/*
 * 2つのテーブル(tbl_cart,mst_product)をJOINした結果を格納するためのDTO
 */

import java.sql.Timestamp;

public class CartDto {

	/*TblCart.id -Primary key*/
	private int id;
	/*MstProduct.image_full_path*/
	private String imageFullPath;
	/*MstProduct.product_name*/
	private String productName;
	/*MstProduct.price*/
	private int price;
	/*TblCart.product_count*/
	private int productCount;
	private int subtotal;
	/*TblCart.created_at*/
	private Timestamp createdAt;
	/*TblCart.updated_at*/
	private Timestamp updatedAt;
	
	/*
	 * Getter,Setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImageFullPath() {
		return imageFullPath;
	}
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
