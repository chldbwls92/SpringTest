package com.chldbwls92.spring.test.ajax.favorite;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/favorite")
public class FavoriteController {

	// 서비스에서 가져오는 변수 자동생성
	@Autowired
	private FavoriteService favoriteService;
	
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		model.addAttribute("favoriteList", favoriteService.getFavorite());
	
		return "thymeleaf/ajax/favoriteList";
	}
	
	
	
	// 즐겨찾기 추가 API
	@ResponseBody
	@GetMapping("/create")
	public Map<String, String> createFavorite(
			// 리퀘스트파라미터로 name이랑 url 가져오기
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) {
		
		int count = favoriteService.addFavorite(name, url);
		
		// jason 규격(키, 값)으로 data 만들기
		Map<String, String> resultMap = new HashMap<>();
		
		// 성공하면 1(success), 실패하면 else(fail)
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@GetMapping("input")
	public String favoriteInput() {
		return "thymeleaf/ajax/favoriteInput";
	}
	
	

}



