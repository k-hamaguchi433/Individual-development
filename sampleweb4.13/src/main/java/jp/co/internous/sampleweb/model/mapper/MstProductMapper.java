package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.MstProduct;

/**
 * mst_productにアクセスするDAO
 * @author k-hamaguchi433
 *
 */
@Mapper
public interface MstProductMapper {
	
	/**
	 * 商品情報を取得する
	 * @return 商品情報リスト
	 */
	@Select("SELECT * FROM mst_product")
	List<MstProduct> find();

	/**
	 * カテゴリIDと検索キーワードを条件として商品情報を取得する
	 * @param categoryId
	 * @param keyword
	 * @return 検索済商品リスト
	 */
	List<MstProduct> findByCategoryIdAndProductName(@Param("categoryId")int categoryId, @Param("keywordsList") String[] keywordsList);

	/**
	 * 検索キーワードを条件として商品情報を取得する
	 * @param keyword
	 * @return 検索済商品リスト
	 */
	List<MstProduct> findByProductName(@Param("keywordsList") String[] keywordsList);

	/**
	 * カテゴリIDを条件として商品情報を取得する
	 * @param categoryId
	 * @return 検索済商品リスト
	 */
	@Select("SELECT * FROM mst_product WHERE category_id = #{categoryId}")
	List<MstProduct> findByCategoryId(@Param("categoryId") int categoryId);

}


