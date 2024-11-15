package com.chldbwls92.spring.test.ajax.favorite;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteRepository {
	
	// 전체 return 해주는 repository
	public List<Favorite> selectFavorite();
	
	// 추가해주는 repository
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
}
