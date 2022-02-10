package jp.co.internous.sampleweb.model.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.MstUser;
/**
 * mst_userにアクセスするDAO
 * @author k-hamaguchi433
 */
@Mapper
public interface MstUserMapper {
	
	/**
	 * ユーザー名とパスワードを条件にユーザー情報を取得する
	 * @param userName ユーザー名
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	// @Paramは、パラメータに対する説明を表示する場合に使う。
	// パラメータとは外部から投入される変動要素のこと。
	// MstUser型の FindByUserNameAndPasswordメソッドの作成
	@Select("SELECT * From mst_user WHERE user_name = #{userName} AND password = #{password} ")
	MstUser FindByUserNameAndPassword(
			@Param("userName")String userName,
			@Param("password")String password);
	
	/**
	 * idを条件にユーザー情報を取得する
	 * @param UserId
	 * @return マイページ用ユーザー情報
	 */
	@Select("SELECT * FROM mst_user WHERE id = #{id}")
	MstUser findByUserId(@Param("id")int id);
	

}
