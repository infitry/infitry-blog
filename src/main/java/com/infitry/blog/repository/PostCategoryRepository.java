package com.infitry.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infitry.blog.entity.PostCategory;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : PostCategoryRepository
 */
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
	
}
