package travel.travel_community.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travel.travel_community.apiPayload.ApiResponse;
import travel.travel_community.entity.Music;
import travel.travel_community.service.MusicService;
import travel.travel_community.web.dto.MusicDTO;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/music")
public class MusicController {

    private static final Logger logger = LoggerFactory.getLogger(MusicController.class);

    @Autowired
    private MusicService musicService;

    @GetMapping
    public ApiResponse<List<MusicDTO>> getAllMusic() {
        List<Music> musicList = musicService.getAllMusic();
        List<MusicDTO> dtoList = musicList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ApiResponse.onSuccess(dtoList);
    }

    @GetMapping("/{id}")
    public ApiResponse<MusicDTO> getMusicById(@PathVariable Long id) {
        try {
            Music music = musicService.getMusicById(id);
            return ApiResponse.onSuccess(convertToDTO(music));
        } catch (Exception e) {
            logger.error("Error fetching music with id: " + id, e);
            return ApiResponse.onFailure("404", "Music not found", null);
        }
    }

    private MusicDTO convertToDTO(Music music) {
        MusicDTO dto = new MusicDTO();
        dto.setId(music.getId());
        dto.setTitle(music.getTitle());
        dto.setArtist(music.getArtist());
        String fileName = music.getFilePath().substring(music.getFilePath().lastIndexOf("\\") + 1);
        dto.setFilePath("/music/" + fileName);
        dto.setDuration(music.getDuration());
        logger.debug("Converted file path: " + dto.getFilePath());
        return dto;
    }
}