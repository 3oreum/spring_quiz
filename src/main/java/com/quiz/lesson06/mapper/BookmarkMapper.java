package com.quiz.lesson06.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	public List<Bookmark> selectBookmarkList();
	
	public void insertBookmark(
			@Param("name") String name, 
			@Param("url") String url);
	
	public Bookmark selectBookmarkByUrl(String url);
	
	public void deleteBookmarkById(int id);
	
}
