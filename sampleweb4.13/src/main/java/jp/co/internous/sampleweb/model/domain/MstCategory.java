package jp.co.internous.sampleweb.model.domain;

import java.sql.Timestamp;

/**
 * mst_categoryのドメイン
 * @author k_hamaguchi
 *
 */
public class MstCategory {
	
	private int id;
	private String categoryName;
	private String categoryDescription;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	/**
	 * idを取得する
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * idを設定する
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * カテゴリー名を取得する
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * カテゴリー名を設定する
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/**
	 * カテゴリーの説明を取得する
	 * @return
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}
	
	/**
	 * カテゴリーの説明を設定する
	 * @param categoryDescription
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
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
