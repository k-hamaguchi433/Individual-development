package jp.co.internous.sampleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sampleweb/destination")
public class DestinationController {
	
	/**
	 * destination.html表示
	 * @return destination
	 */
	@RequestMapping("/")
	public String index() {
		return "destination";
	}
	


}
