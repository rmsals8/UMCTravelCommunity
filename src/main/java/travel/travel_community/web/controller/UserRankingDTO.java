package travel.travel_community.web.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import travel.travel_community.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRankingDTO {
    private Long id;
    private String nickname;
    private int postCount;
    private int likeCount;
    private int scrapCount;

    public UserRankingDTO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.postCount = user.getAuthoredPosts().size();
        this.likeCount = user.getAuthoredPosts().stream().mapToInt(TravelPost::getLikeCount).sum();
        this.scrapCount = user.getScrappedPosts().size();
    }
}
