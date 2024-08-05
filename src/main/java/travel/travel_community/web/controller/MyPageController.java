package travel.travel_community.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.travel_community.entity.UserProfile;
import travel.travel_community.service.MyPageService;
import travel.travel_community.web.dto.MyPageDTO;
import travel.travel_community.web.dto.UserAddressDTO;
import travel.travel_community.web.dto.UserProfileDTO;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/mypage")
public class MyPageController {
    private static final Logger logger = Logger.getLogger(MyPageController.class.getName());

    @Autowired
    private MyPageService myPageService;

//    @GetMapping("/{userId}/addresses")
//    public ResponseEntity<UserAddressDTO> getUserAddresses(@PathVariable Long userId) {
//        try {
//            UserAddressDTO userAddresses = myPageService.getUserAddresses(userId);
//            return ResponseEntity.ok(userAddresses);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long userId) {
        try {
            UserProfileDTO userProfileDTO = myPageService.getUserProfile(userId);
            return ResponseEntity.ok(userProfileDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}