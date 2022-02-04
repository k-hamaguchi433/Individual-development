package jp.co.internous.sampleweb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import jp.co.internous.sampleweb.model.domain.MstDestination;
import jp.co.internous.sampleweb.model.mapper.MstDestinationMapper;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

@Controller
@RequestMapping("/sampleweb/settlement")
public class SettlementController {
	
	@Autowired
	private LoginSession loginSession;	
	@Autowired
	private MstDestinationMapper destinationMapper;
	@Autowired
	private TblPurchaseHistoryMapper purchaseHistoryMapper;
	@Autowired
	private TblCartMapper cartMapper;

	
	Gson gson = new Gson();
	
	
	/**
	 * settlement.html表示
	 * @return settlement
	 */
	/*
	 * mst_destinationテーブルからデータを取得する（ユーザーに紐づく情報のみ、idの昇順ASC）
	 */
	@RequestMapping("/")
	public String settlement(Model m) {
		//ログイン中のユーザIDを検索
		int userId = loginSession.getUserId();	
		
		List<MstDestination> destinations = destinationMapper.findByUserId(userId);
		
		m.addAttribute("destinations", destinations);
		m.addAttribute("loginSession", loginSession);
		
		return "settlement";
	}
	
	/**
	 * 決済
	 * result=1 return 商品購入画面
	 */
	/*
	 * tbl_purchase_historyテーブルに決済情報を登録
	 * 登録成功した場合、商品購入履歴画面purchase_history.htmlに遷移
	 * 
	 */
	@RequestMapping("/complete")
	public String complete(@RequestBody String destinationIds, Model m) {
		
		// ユーザーIDを変数userIdに取得
		int userId = loginSession.getUserId();
		
		//destinationIdsをJsonからjavaに変換
		int destinationId = gson.fromJson(destinationIds, int.class);

		int result = 0;
		result = purchaseHistoryMapper.insert(userId,destinationId);
		
		if (result > 0) {
			result = 0;
			result = cartMapper.deleteByUserId(userId);
			
		}
		
		m.addAttribute("loginSession", loginSession);

		return "settlement";
	}

}
