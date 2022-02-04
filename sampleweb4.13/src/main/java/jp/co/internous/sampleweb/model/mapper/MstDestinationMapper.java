package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.MstDestination;

@Mapper
public interface MstDestinationMapper {
	
	/**
	 * mst_destinationテーブルからデータを取得する（ユーザーに紐づく情報のみ、idの昇順ASC）
	 */
	@Select("SELECT * FROM mst_destination WHERE user_id = #{userId} ORDER BY id ASC;")
	List<MstDestination> findByUserId(@Param("userId") int userId);
}
