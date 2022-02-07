package jp.co.internous.sampleweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.sampleweb.model.domain.TblCart;
import jp.co.internous.sampleweb.model.domain.dto.CartDto;
import jp.co.internous.sampleweb.model.form.CartForm;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * カート情報に関する処理のコントローラー
 * @author k-hamaguchi433
 */
@Controller
@RequestMapping("/sampleweb/cart")
public class CartController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private TblCartMapper cartMapper;
	
	Gson gson = new Gson();
	

	/**
	 * カート画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		// ログインの有無でユーザIDを検索
		// isLogined()がtrueならばgetUserId()、falseならばgetTmpUserId()を変数userIdに代入
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		// カート情報を取得
		List<CartDto> carts = cartMapper.findByUserId(userId);
		
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("carts",carts);
		m.addAttribute("loginSession", loginSession);
		return "cart";
		
	}
	
	/**
	 * カートに追加処理を行う
	 * @param f カート情報のForm
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		
		// ユーザーIDを変数userIdに取得し、CartFormにuserIdをセット
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		f.setUserId(userId);
		
		// カートテーブルに挿入/更新
		// 引数がCartFormのコンストラクタをインスタンス化。
		// 変数resultに0を代入。
		// もし、（findCountByUserIdAndProuductId）すでにtbl_cartにuserIdとproductIdが同じものがあれば、
		// （update）ユーザーIDと商品IDを条件に個数を更新する
		// なければ、（insert）カート情報を登録する
		// resultの処理について、cartMapper.update(cart);の処理が成功したら、1を失敗したら-1を返す
		TblCart cart = new TblCart(f);
		int result = 0;
		if (cartMapper.findCountByUserIdAndProuductId(userId, f.getProductId()) > 0) {
			result = cartMapper.update(cart);
		} else {
			result = cartMapper.insert(cart);
		}
		if (result > 0) {
			List<CartDto> carts = cartMapper.findByUserId(userId);
			// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
			m.addAttribute("loginSession", loginSession);
			m.addAttribute("carts", carts);
		}
		return "cart";
	}
	
	/**
	 * カート情報を削除する
	 * @param checkedIdList 選択したカート情報のIDリスト
	 * @return true:削除成功、false:削除失敗
	 */
	// @SuppressWarnings("unchecked") Javaでチェックされていない警告を抑制
	@SuppressWarnings("unchecked") 
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		
		int result = 0;
		
		// fromJson → JSONからJavaへ変換する（デシリアライズ）
		// cart.htmlから送られてきたJSON文字をjavaで処理するために、
		// キーにJOINデータである checkedIdList と、値にjavaで使えるデータとしてMap.classをセットする。
		// SQLにデータを送るためのListに値を格納する
		// cartMapper.deleteById(checkedIds)の結果（1か‐1）をresultに代入
		Map<String, List<Integer>> map = gson.fromJson(checkedIdList, Map.class);
		List<Integer> checkedIds = map.get("checkedIdList");
		
		result = cartMapper.deleteById(checkedIds);
		
		return result > 0;
		
	}
	
	
}