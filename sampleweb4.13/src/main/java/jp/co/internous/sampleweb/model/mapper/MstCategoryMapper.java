package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.MstCategory;

/**
 * mst_categoryにアクセスするDAO
 * @author k_hamaguchi
 *
 */
@Mapper
public interface MstCategoryMapper {

	/**
	 * 商品のカテゴリーを取得する
	 * @return 商品カテゴリーリスト
	 */
	@Select("SELECT * FROM mst_category")
	List<MstCategory> find();

}
