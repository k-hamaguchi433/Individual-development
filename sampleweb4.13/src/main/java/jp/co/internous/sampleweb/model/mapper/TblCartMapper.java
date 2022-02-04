package jp.co.internous.sampleweb.model.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sampleweb.model.domain.TblCart;
import jp.co.internous.sampleweb.model.domain.dto.CartDto;

@Mapper
public interface TblCartMapper {
	
	/**
	 * ユーザーIDを条件にカート情報を取得する
	 * @param userId ユーザーID
	 * @return カート情報リスト
	 */
	List<CartDto> findByUserId(@Param("userId") int userId);
	
	/**
	 * カート情報を登録する
	 * @param cart カート情報
	 * @return 登録件数
	 */
	@Insert("INSERT INTO tbl_cart ("
			+ "user_id, product_id, product_count "
			+ ") "
			+ "VALUES ("
			+ "#{userId}, #{productId}, #{productCount} "
			+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(TblCart cart);
	
	/**
	 * ユーザーIDと商品IDを条件に個数を更新する
	 * @param cart カート情報
	 * @return 更新件数
	 */
	@Update("UPDATE tbl_cart SET product_count = product_count + #{productCount}, updated_at = now() WHERE user_id = #{userId} AND product_id = #{productId}")
	int update(TblCart cart);
	
	/**
	 * ユーザーIDを条件に件数を取得する
	 * @param userId ユーザーID
	 * @return 件数
	 */
	@Select("SELECT count(user_id) FROM tbl_cart WHERE user_id = #{userId}")
	int findCountByUserId(@Param("userId") int userId);
	
	/**
	 * ユーザーIDを条件にユーザーIDを更新する
	 * @param userId ユーザーID
	 * @param tmpUserId 仮ユーザーID
	 * @return 更新件数
	 */
	@Update("UPDATE tbl_cart SET user_id = #{userId}, updated_at = now() WHERE user_id = #{tmpUserId}")
	int updateUserId(@Param("userId") int userId, @Param("tmpUserId") int tmpUserId);
	
	/**
	 * ユーザーIDと商品IDを条件に件数を取得する
	 * @param userId ユーザーID
	 * @param productId 商品ID
	 * @return 件数
	 */
	@Select("SELECT count(id) FROM tbl_cart WHERE user_id = #{userId} AND product_id = #{productId}")
	int findCountByUserIdAndProuductId(@Param("userId") int userId, @Param("productId") int productId);
	
//	@Delete("DELETE FROM tbl_cart WHERE id = #{id}")
//	int deleteById(@Param("id") int id);
	
	/**
	 * IDを条件にカート情報を削除する
	 * @param checkedIds
	 * @return 削除件数
	 */
	int deleteById(@Param("checkedIds") List<Integer> checkedIds);
	
	/**
	 * ユーザーIDを条件にカート情報を削除する
	 * @param userId ユーザーID
	 * @return 削除件数
	 */
	@Delete("DELETE FROM tbl_cart WHERE user_id = #{userId}")
	int deleteByUserId(@Param("userId") int userId);
	
}
