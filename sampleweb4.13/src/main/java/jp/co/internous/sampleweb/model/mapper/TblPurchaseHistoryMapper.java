package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sampleweb.model.domain.dto.PurchaseHistoryDto;

/**
 * tbl_purchase_historyにアクセスするDAO
 * @author k-hamaguchi433
 */
@Mapper
public interface TblPurchaseHistoryMapper {
	
	/**
	 * 購入履歴情報を登録する
	 * @param parameter パラメーター(ユーザーID、宛先情報ID)
	 * @return 登録件数
	 */
	int insert(@Param("userId") int userId, @Param("destinationId") int destinationId);

	/**
	 * ユーザーIDを条件に購入履歴情報を取得する
	 * @param userId ユーザーID
	 * @return 購入履歴情報リスト
	 */
	List<PurchaseHistoryDto> findByUserId(@Param("userId")int userId);

	/**
	 * ユーザーIDを条件に論理削除する
	 * @param userId ユーザーID
	 * @return 削除件数
	 */
	@Update("UPDATE tbl_purchase_history SET status = 0, updated_at = now() WHERE user_id = #{userId}")
	int logicalDeleteByUserId(@Param("userId")int userId);
	


}
