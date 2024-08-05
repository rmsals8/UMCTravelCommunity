package travel.travel_community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import travel.travel_community.entity.User;

import java.util.List;

public interface UserRepository2 extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM user ORDER BY RAND() LIMIT 30", nativeQuery = true)
    List<User> findTop30ByOrderByCreatedAtDesc();

    @Query(value = "SELECT u.* FROM user u LEFT JOIN travel_posts p ON u.id = p.user_id GROUP BY u.id ORDER BY SUM(COALESCE(p.like_count, 0)) DESC, RAND() LIMIT 30", nativeQuery = true)
    List<User> findTop30ByTotalLikes();

    @Query(value = "SELECT u.* FROM user u LEFT JOIN travel_posts p ON u.id = p.user_id GROUP BY u.id ORDER BY COUNT(COALESCE(p.id, 0)) DESC, RAND() LIMIT 30", nativeQuery = true)
    List<User> findTop30ByTotalPosts();

    @Query(value = "SELECT u.* FROM user u LEFT JOIN travel_post_scraps s ON u.id = s.user_id GROUP BY u.id ORDER BY COUNT(s.id) DESC, RAND() LIMIT 30", nativeQuery = true)
    List<User> findTop30ByTotalScraps();




}
