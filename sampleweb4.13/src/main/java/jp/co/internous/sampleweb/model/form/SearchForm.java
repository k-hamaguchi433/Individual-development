package jp.co.internous.sampleweb.model.form;

import java.io.Serializable;

/**
 * 検索用フォーム
 * @author k_hamaguchi
 *
 */
public class SearchForm implements Serializable{
	private static final long serialVersionUID = -8126141435930909097L;
	
	private int categoryId;
	private String keywords;
	
	/**
	 * カテゴリIDを取得
	 * @return　カテゴリID
	 */
	public int getCategoryId() {
		return categoryId;
	}
	
	/**
	 * カテゴリIDを設定
	 * @param categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * キーワードを取得
	 * @return　キーワード
	 */
	public String getKeywords() {
		return keywords;
	}
	
	/**
	 * キーワードを設定
	 * @param keyword
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
