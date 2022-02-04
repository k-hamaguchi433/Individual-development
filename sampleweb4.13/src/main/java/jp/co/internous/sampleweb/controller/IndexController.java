package jp.co.internous.sampleweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import jp.co.internous.sampleweb.model.domain.MstCategory;
import jp.co.internous.sampleweb.model.domain.MstProduct;
//import jp.co.internous.sampleweb.model.mapper.MstCategoryMapper;
import jp.co.internous.sampleweb.model.mapper.MstProductMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;


@Controller
@RequestMapping("/sampleweb")
public class IndexController {
	
	//@Autowired
	//private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;

	@Autowired
	private LoginSession loginSession;
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		/*
		 * もし、loginSessionのisLoginedの値がfalse(!)かつ、loginSessionのtmpUserIdが0の場合
		 * 乱数をローカル変数tmpUserに代入(Math.random()[0~0.999..] × 1000000000)
		 */
		if (!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			// 仮ユーザーIDが9桁になるまで10倍する
			while (tmpUserId > -100000000) {
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		
		
		
		// カテゴリを取得
		//List<MstCategory> categories = categoryMapper.find();
	
		
	
		// 商品情報を取得
		List<MstProduct> products = productMapper.find();
		//m.addAttribute("categories",categories);
		//m.addAttribute("selected",0);
		m.addAttribute("products",products);
		// page_header.htmlでsessionの変数を表示させているため、loginSessionも画面に送る。
		m.addAttribute("loginSession",loginSession);
		
		return "index";
	}
	
}
