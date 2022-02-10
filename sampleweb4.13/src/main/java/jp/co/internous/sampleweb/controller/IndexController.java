package jp.co.internous.sampleweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sampleweb.model.domain.MstCategory;
import jp.co.internous.sampleweb.model.domain.MstProduct;
import jp.co.internous.sampleweb.model.form.SearchForm;
import jp.co.internous.sampleweb.model.mapper.MstCategoryMapper;
import jp.co.internous.sampleweb.model.mapper.MstProductMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author k-hamaguchi433
 */
@Controller
@RequestMapping("/sampleweb")
public class IndexController {
	
	@Autowired
	private MstProductMapper productMapper;

	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		// もし、loginSessionのisLoginedの値がfalse(!)かつ、loginSessionのtmpUserIdが0の場合
		// 乱数をローカル変数tmpUserに代入(Math.random()[0~0.999..] × 1000000000)
		if (!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			// 仮ユーザーIDが9桁になるまで10倍する
			while (tmpUserId > -100000000) {
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		
		//mst_categoryからcategory_nameを取得
		List<MstCategory> categories = categoryMapper.find();
	
		// 商品情報を取得
		List<MstProduct> products = productMapper.find();
		m.addAttribute("products",products);
		m.addAttribute("categories",categories);
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("loginSession",loginSession);
		
		return "index";
		
	}
	
	/**
	 * 商品検索し画面に返す
	 * @param f
	 * @param m
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {
		
		//javaでkeywordsを受け取る際にスペースを整える
		//.replaceAll("A", "B")AをBに置き換え　.trim()文字列前後のスペースを削除
		String keywords = f.getKeywords().replaceAll("　", " ").trim().replaceAll("\\s+", " ");
		int categoryId = f.getCategoryId();	
		
		//.split("A")　A区切りで単語を分割　
		String[] keywordsList = keywords.split(" ");	
		
		List<MstProduct> products = null;
		
		//もし、検索ワードが入力されているかつカテゴリー選択済であればfindByCategoryIdAndProductNameを実行
		//上記以外でもし、検索ワードが入力されている場合はfindByProductNameを実行
		if(keywordsList != null && categoryId > 0){
			products = productMapper.findByCategoryIdAndProductName(categoryId, keywordsList);
		}else if(keywordsList != null){
			products = productMapper.findByProductName(keywordsList);
		}
		
		//mst_categoryからカテゴリー検索用にcategory_nameを取得
		List<MstCategory> categories = categoryMapper.find();
		
		m.addAttribute("categories",categories);
		m.addAttribute("products",products);
		m.addAttribute("loginSession",loginSession);
		return "index";
	}
	
}
