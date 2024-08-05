package travel.travel_community.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.travel_community.apiPayload.ApiResponse;
import travel.travel_community.entity.User;
import travel.travel_community.service.UserRankingService;
//import travel.travel_community.web.dto.UserRankingDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rankings")
public class UserRankingController {

    @Autowired
    private UserRankingService userRankingService;

    @GetMapping("/top30/join-date")
    public ApiResponse<List<UserRankingDTO>> getTop30ByJoinDate() {
        List<User> users = userRankingService.getTop30ByJoinDate();
        return ApiResponse.onSuccess(convertToDTOList(users));
    }

    @GetMapping("/top30/likes")
    public ApiResponse<List<UserRankingDTO>> getTop30ByLikes() {
        List<User> users = userRankingService.getTop30ByLikes();
        return ApiResponse.onSuccess(convertToDTOList(users));
    }

    @GetMapping("/top30/scraps")
    public ApiResponse<List<UserRankingDTO>> getTop30ByScraps() {
        List<User> users = userRankingService.getTop30ByScraps();
        return ApiResponse.onSuccess(convertToDTOList(users));
    }

    @GetMapping("/top30/posts")
    public ApiResponse<List<UserRankingDTO>> getTop30ByPosts() {
        List<User> users = userRankingService.getTop30ByPosts();
        return ApiResponse.onSuccess(convertToDTOList(users));
    }

    private List<UserRankingDTO> convertToDTOList(List<User> users) {
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserRankingDTO convertToDTO(User user) {
        return new UserRankingDTO(user);
    }
}