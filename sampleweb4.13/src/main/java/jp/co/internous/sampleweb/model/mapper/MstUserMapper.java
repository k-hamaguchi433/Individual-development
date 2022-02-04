package jp.co.internous.sampleweb.model.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sampleweb.model.domain.MstUser;
/**
 * mst_userにアクセスするDAO
 * @author インターノウス
 * インターフェイスのメソッドは、アクセス修飾子がない。
 */
@Mapper
public interface MstUserMapper {
	
	/**
	 * ユーザー名とパスワードを条件にユーザー情報を取得する
	 * @param userName ユーザー名
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	/**@Paramは、パラメータに対する説明を表示する場合に使う。
	 * パラメータとは外部から投入される変動要素のこと。*/
	/*MstUser型の FindByUserNameAndPasswordメソッドの作成*/
	@Select("SELECT * From mst_user WHERE user_name = #{userName} AND password = #{password} ")
	MstUser FindByUserNameAndPassword(
			@Param("userName")String userName,
			@Param("password")String password);
	
	@Update("UPDATE mst_user SET password = #{newPassword} WHERE user_name = #{userName}")
	MstUser updatePassword(
			@Param("userName")String userName,
			@Param("password")String password);
	

}
