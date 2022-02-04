package jp.co.internous.sampleweb.model.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sampleweb.model.domain.dto.PurchaseHistoryDto;


@Mapper
public interface TblPurchaseHistoryMapper {
	
	
	//@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(@Param("userId") int userId, @Param("destinationId") int destinationId);

	List<PurchaseHistoryDto> findByUserId(@Param("userId")int userId);

	@Update("UPDATE tbl_purchase_history SET status = 0, updated_at = now() WHERE user_id = #{userId}")
	int updateStatus(@Param("userId")int userId);
	


}
