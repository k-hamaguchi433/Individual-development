package jp.co.internous.sampleweb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jp.co.internous.sampleweb.model.domain.MstUser;
import jp.co.internous.sampleweb.model.form.UserForm;
import jp.co.internous.sampleweb.model.mapper.MstUserMapper;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

// javadoc → プログラムについて説明するコメント
/**
 * 認証に関する処理を行うコントローラー
 * @author k-hamaguchi433
 */
// @RestControllerは、リクエストを受け、JSONやXMLを返すAPIサーバー用として使用する
// @Controllerは、戻り値としてView(HTML)を返す際に使うアノテーション
@RequestMapping("/sampleweb/auth")
@RestController
public class AuthController {
	
	private Gson gson = new Gson();
	
	// @Autowired は、他のクラスを呼び出すときにnewがいらなくなる
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private TblCartMapper cartMapper;
	
	
	/**
	 * ログイン処理をおこなう
	 * @param f ユーザーフォーム
	 * @return ログインしたユーザー情報(JSON形式)
	 */
	// @ResponseBodyは、return文で返却される文字列そのものが、レスポンスの本体(body)
	// であることを設定するアノテーション。WebサービスAPIなどで利用される重要なアノテーション。
	// @RequestBody は、RequestBodyの内容（今回はUserForm）をそのまま取得できる
	// @ModelAttribute は、変数formにフォームの値をつめる
	// 指定したクラスにリクエストパラメータをバインド(AとBを紐づけする)します。
	@RequestMapping("/login")
	// Postされた内容をUserFormで受け取る
	public String login(@RequestBody UserForm f) {
		
		// MstUserをインスタンス化した、変数userにFindByUserNameAndPasswordでDBと照合されたユーザー情報を代入する。
		// formの情報を引数に設定して、userMapperのFindByUserNameAndPasswordメソッドを呼び出し、
		// formのuserNameとpasswordで全カラムをSELECT。
		// MstUser型のローカル変数userにSELECTされた値を代入。
		MstUser user = userMapper.FindByUserNameAndPassword(f.getUserName(),f.getPassword());
		
		//仮ユーザIDをgetterで取得
		int tmpUserId = loginSession.getTmpUserId();
		// 仮IDでカート追加されていれば、本ユーザーIDに更新する。
		if(user != null && tmpUserId != 0) {
			int count = cartMapper.findCountByUserId(tmpUserId);
			if(count > 0) {
				cartMapper.updateUserId(user.getId(),tmpUserId);
			}
		}
		
		// もし、変数userがnullでなければloginSessionに値をset。
		// そうでない場合は、loginSessionにelse以下の値をset。
		if(user != null) {
			loginSession.setTmpUserId(0);
			loginSession.setLogined(true);
			loginSession.setUserId(user.getId());
			loginSession.setUserName(user.getUserName());
			loginSession.setPassword(user.getPassword());
		}else {
			loginSession.setLogined(false);
			loginSession.setUserId(0);
			loginSession.setUserName(null);
			loginSession.setPassword(null);
		}
		// JavaオブジェクトからJSONへの変換しhtml側で使えるようにする
		return gson.toJson(user);
		
	}

	/**
	 * ログアウト処理をおこなう
	 * @return 空文字
	 */
	@RequestMapping("/logout")
	public String logout() {
		
		loginSession.setUserId(0);
		loginSession.setTmpUserId(0);
		loginSession.setUserName(null);
		loginSession.setPassword(null);
		loginSession.setLogined(false);
		
		return "";
		
	}

}
