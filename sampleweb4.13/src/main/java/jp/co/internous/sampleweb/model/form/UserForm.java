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
	//多分使ってないやつ？？月曜に動作確認してから消す
	//private String familyName;
	//private String firstName;
	//private String familyNameKana;
	//private String firstNameKana;
	//private byte gender;
	//private String newPassword;
	//private String newPasswordConfirm;
	
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
/*	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana (String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana (String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	
	public byte getGender() {
		return gender;
	}
	public void setGender (byte gender) {
		this.gender = gender;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}
	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}
*/
}
