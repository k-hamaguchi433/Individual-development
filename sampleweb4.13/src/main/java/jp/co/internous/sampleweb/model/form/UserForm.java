package jp.co.internous.sampleweb.model.form;

import java.io.Serializable;

/**
 * ユーザーフォーム
 * @author k-hamaguchi433
 *
 */
public class UserForm implements Serializable{
	private static final long serialVersionUID = 5749720167585388139L;
	
	private String userName;
	private String password;
	
	
	/**
	 * ユーザー名を取得する
	 * @return ユーザー名
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * ユーザー名を設定する
	 * @param userName ユーザー名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * パスワードを取得する
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワードを設定する
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
