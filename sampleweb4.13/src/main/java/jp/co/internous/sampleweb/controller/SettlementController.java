package jp.co.internous.sampleweb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import jp.co.internous.sampleweb.model.domain.MstDestination;
import jp.co.internous.sampleweb.model.mapper.MstDestinationMapper;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 決済に関する処理を行うコントローラー
 * @author k-hamaguchi433
 */
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
	 * 宛先選択・決済画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return 宛先選択・決済画面
	 */
	@RequestMapping("/")
	public String settlement(Model m) {
		
		//ログイン中のユーザIDを検索
		int userId = loginSession.getUserId();	
		
		//mst_destinationテーブルからデータを取得する（ユーザーに紐づく情報のみ、idの昇順ASC）
		List<MstDestination> destinations = destinationMapper.findByUserId(userId);
		
		m.addAttribute("destinations", destinations);
		m.addAttribute("loginSession", loginSession);
		
		return "settlement";
		
	}
	
	/**
	 * 決済処理を行う
	 * @param id 宛先情報id
	 * @return true:決済処理成功、false:決済処理失敗
	 */
	//@RequestParam formのパラメータ(name="id")を取得
	@RequestMapping("/complete")
	public String complete(@RequestParam int id, Model m) {
		
		int userId = loginSession.getUserId();
		
		int result = 0;
		result = purchaseHistoryMapper.insert(userId,id);
		
		if (result > 0) {
			result = 0;
			result = cartMapper.deleteByUserId(userId);
		}
		
		m.addAttribute("loginSession", loginSession);
		
		return "forward:/sampleweb/history/";
	}

}
