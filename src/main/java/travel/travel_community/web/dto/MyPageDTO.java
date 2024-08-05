package travel.travel_community.web.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import travel.travel_community.entity.enums.FavoriteCountry;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDTO {
    private Long userId;
    private String nickname;
    private LocalDateTime createdDate;
    private byte[] profileImage;
    private String biography;
    private List<String> snsAddresses;
    private String location;
    private FavoriteCountry favoriteCountry;
    private String currentAddresses;
    private String newAddresses;
}