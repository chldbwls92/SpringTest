package com.chldbwls92.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList() {
		
		List<Map<String, Object>> movieLists = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		movieLists.add(movie);
		
		// 다 다뤘기 때문에 재사용 가능(새로운 맵에 대한 기능 수행)
		movie = new HashMap<>();
		movie.put("rate", 0);
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
		movieLists.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 113);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieLists.add(movie);
		
		movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
		movieLists.add(movie);
		
		return movieLists;
		
	}
	
	
	@RequestMapping("/2")
	public List<text> textList() {
		List<text> textList = new ArrayList<>();
		text Text = new text("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		textList.add(Text);
		
		textList.add(new text("헐 대박", "bada", "오늘 목요일이었어.. 금요일인줄"));
		textList.add(new text("오늘 데이트 한 이야기 해드릴게요", "dulumary", "...."));
		return textList;
	}
	
	
	@RequestMapping("/3")
	public ResponseEntity<text> textError() {
		text Text = new text("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		ResponseEntity<text> entity = new ResponseEntity<>(Text,HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}


}
