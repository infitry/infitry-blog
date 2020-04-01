package com.infitry.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infitry.blog.entity.BlogPost;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : blogPostRepository
 */
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
	
}
