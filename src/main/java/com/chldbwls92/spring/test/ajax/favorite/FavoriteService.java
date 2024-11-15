package com.chldbwls92.spring.test.ajax.favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	// 모든 정보 가져오는 service
	public List<Favorite> getFavorite() {
		
		List<Favorite> favorite = favoriteRepository.selectFavorite();
		
		return favorite;
	}
	
	// 추가하는 service
	public int addFavorite(
			String name
			, String url
			) {
		int count = favoriteRepository.insertFavorite(name, url);
		return count;
	}
	
	

}
