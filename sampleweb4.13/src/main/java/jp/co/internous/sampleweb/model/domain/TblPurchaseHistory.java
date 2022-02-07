package jp.co.internous.sampleweb.model.domain;

import java.sql.Timestamp;

/**
 * tbl_purchase_historyのドメイン
 * @author k-hamaguchi433
 */
public class TblPurchaseHistory {
	
	private int id;
	private int userId;
	private int productId;
	private int productCount;
	private int price;
	private int destinationId;
	private long status;
	private Timestamp purchasedAt;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	
	/**
	 * IDを取得する
	 * @return ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * IDを設定する
	 * @param id ID
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * ユーザーIDを取得する
	 * @return ユーザーID
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * ユーザーIDを設定する
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * 商品IDを取得する
	 * @return 商品ID
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * 商品IDを設定する
	 * @param productId 商品ID
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * 個数を取得する
	 * @return 個数
	 */
	public int getProductCount() {
		return productCount;
	}
	
	/**
	 * 個数を設定する
	 * @param productCount 個数
	 */
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	/**
	 * 価格を取得する
	 * @return 価格
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 価格を設定する
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 宛先情報IDを取得する
	 * @return 宛先情報ID
	 */
	public int getDestinationId() {
		return destinationId;
	}
	
	/**
	 * 宛先情報IDを設定する
	 * @param destinationId 宛先情報ID
	 */
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	
	/**
	 * ステータスを取得する
	 * @return ステータス
	 */
	public long getStatus() {
		return status;
	}
	
	/**
	 * ステータスを設定する
	 * @param status ステータス
	 */
	public void setStatus(long status) {
		this.status = status;
	}
	
	/**
	 * 購入日時を取得する
	 * @return 購入日時
	 */
	public Timestamp getPurchasedAt() {
		return purchasedAt;
	}
	
	/**
	 * 購入日時を設定する
	 * @param purchasedAt 購入日時
	 */
	public void setPurchasedAt(Timestamp purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	
	/**
	 * 登録日時を取得する
	 * @return 登録日時
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * 登録日時を設定する
	 * @param createdAt 登録日時
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * 更新日時を取得する
	 * @return 更新日時
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * 更新日時を設定する
	 * @param updatedAt 更新日時
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}
