package travel.travel_community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.travel_community.entity.Music;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music,Long> {
    List<Music> findAllByOrderByCreatedAtDesc();
}
