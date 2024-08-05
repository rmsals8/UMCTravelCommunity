package travel.travel_community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.travel_community.entity.Music;
import travel.travel_community.repository.MusicRepository;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    public List<Music> getAllMusic() {
        return musicRepository.findAllByOrderByCreatedAtDesc();
    }

    public Music getMusicById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }
}