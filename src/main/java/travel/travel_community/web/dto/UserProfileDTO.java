package travel.travel_community.web.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import travel.travel_community.entity.enums.FavoriteCountry;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProfileDTO {
//    private Long id;
    private String nickname;
    private Long userId;
    private byte[] profileImage;
    private String biography;
    private String snsAddress;
    private String location;
    private FavoriteCountry favoriteCountry;

    // 생성자, getter, setter 생략
}