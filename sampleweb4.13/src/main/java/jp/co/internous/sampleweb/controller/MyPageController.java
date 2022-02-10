package jp.co.internous.sampleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sampleweb.model.domain.MstUser;
import jp.co.internous.sampleweb.model.mapper.MstUserMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * マイページ表示処理用コントローラー
 * @author k_hamaguchi
 *
 */
@Controller
@RequestMapping("/sampleweb/mypage")
public class MyPageController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstUserMapper userMapper;
	
	/**
	 * マイページ初期表示
	 * @return　マイページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		int id = loginSession.getUserId();
		
		//userIdでユーザー情報を取得
		MstUser user = userMapper.findByUserId(id);
		
		m.addAttribute("user",user);
		m.addAttribute("loginSession",loginSession);
		return "my_page";
	}

}
