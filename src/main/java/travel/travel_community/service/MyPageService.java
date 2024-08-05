package travel.travel_community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travel.travel_community.entity.User;
import travel.travel_community.entity.UserProfile;
import travel.travel_community.repository.UserProfileRepository;
import travel.travel_community.web.dto.MyPageDTO;
import travel.travel_community.web.dto.UserAddressDTO;
import travel.travel_community.web.dto.UserProfileDTO;
import travel.travel_community.repository.UserRepositrory1;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class MyPageService {
    private static final Logger logger = Logger.getLogger(MyPageService.class.getName());

    @Autowired
    private UserProfileRepository userProfileRepository;




//    public UserAddressDTO getUserAddresses(Long userId) {
//        return userProfileRepository.findUserAddressesByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("User addresses not found for userId: " + userId));
//    }
@Autowired
private UserRepositrory1 userRepository;  // User 엔티티에 접근하기 위해 추가

    public UserProfileDTO getUserProfile(Long userId) {
        UserProfile userProfile = userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("UserProfile not found for userId: " + userId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found for userId: " + userId));

        String newSnsAddresses = userProfileRepository.findSnsAddressesByUserId(userId)
                .orElse("");

        UserProfileDTO dto = new UserProfileDTO();
        dto.setNickname(((User) user).getNickname());  // id 대신 nickname 설정
        dto.setUserId(userId);
        dto.setProfileImage(userProfile.getProfileImage());
        dto.setBiography(userProfile.getBiography());
        dto.setSnsAddress(newSnsAddresses);
        dto.setLocation(userProfile.getLocation());
        dto.setFavoriteCountry(userProfile.getFavoriteCountry());

        return dto;
    }

//    public UserProfileDTO getUserProfile(Long userId) {
//        UserProfile userProfile = userProfileRepository.findByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("UserProfile not found for userId: " + userId));
//
//        String newSnsAddresses = userProfileRepository.findSnsAddressesByUserId(userId)
//                .orElse("");
//
//        UserProfileDTO dto = new UserProfileDTO();
//        dto.setId(userProfile.getId());
//        dto.setUserId(userId);
//        dto.setProfileImage(userProfile.getProfileImage());
//        dto.setBiography(userProfile.getBiography());
//        dto.setSnsAddress(newSnsAddresses);  // 새로운 SNS 주소로 업데이트
//        dto.setLocation(userProfile.getLocation());
//        dto.setFavoriteCountry(userProfile.getFavoriteCountry());
//
//        return dto;
//    }

}