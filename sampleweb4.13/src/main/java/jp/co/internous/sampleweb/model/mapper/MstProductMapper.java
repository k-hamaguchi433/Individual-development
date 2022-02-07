package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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

}


