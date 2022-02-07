package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.MstDestination;

/**
 * mst_destinationにアクセスするDAO
 * @author k-hamaguchi433
 *
 */
@Mapper
public interface MstDestinationMapper {
	
	/**
	 * ユーザーIDを条件に宛先情報を取得する
	 * @param userId ユーザーID
	 * @return 宛先情報リスト
	 */
	@Select("SELECT * FROM mst_destination WHERE user_id = #{userId} ORDER BY id ASC;")
	List<MstDestination> findByUserId(@Param("userId") int userId);
}
