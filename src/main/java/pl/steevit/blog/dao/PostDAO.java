package pl.steevit.blog.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.steevit.blog.entity.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long> {
	
	/*@Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
	List<Post> findLatest5Posts(Pageable pageable);*/
	
	@Query("SELECT p FROM Post p LEFT JOIN p.author ORDER BY p.date DESC")	
	Page<Post> findPosts(Pageable pageable);
	
	@Override
    @Query
    public List<Post> findAll();
	
}
