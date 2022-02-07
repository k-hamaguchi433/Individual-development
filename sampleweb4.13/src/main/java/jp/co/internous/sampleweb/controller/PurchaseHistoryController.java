package jp.co.internous.sampleweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sampleweb.model.domain.dto.PurchaseHistoryDto;
import jp.co.internous.sampleweb.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 購入履歴情報に関する処理を行うコントローラー
 * @author k-hamaguchi433
 */
@Controller
@RequestMapping("/sampleweb/history")
public class PurchaseHistoryController {
	
	@Autowired
	private LoginSession loginSession;
	@Autowired
	private TblPurchaseHistoryMapper purchaseHistoryMapper;
	

	/**
	 * 購入履歴画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return 購入履歴画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		int userId = loginSession.getUserId();	
		
		// ユーザーに紐づく購入情報を取得（購入日時の降順DESC、statusが1のもののみ取得）
		// DB情報は3つのテーブル(tbl_purchase_history,mst_product,mst_destination)から取得
		List<PurchaseHistoryDto> purchaseHistory = purchaseHistoryMapper.findByUserId(userId);
		
		m.addAttribute("purchaseHistory",purchaseHistory);
		m.addAttribute("loginSession", loginSession);
		return "purchase_history";
		
	}
	
	/**
	 * 購入履歴情報を論理削除する
	 * @return true:削除成功、false:削除失敗
	 */
	@RequestMapping("/delete")
	public String deletePurchaseHistory(Model m) {
		int userId = loginSession.getUserId();	
		
		// tbl_purchase_historyから購入履歴を倫理削除(statusを0に更新する)
		// 成功した)場合は商品購入テーブルから購入履歴情報を削除する。
		purchaseHistoryMapper.logicalDeleteByUserId(userId);
		
		return "purchase_history";
		
	}
	
}
