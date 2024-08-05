package travel.travel_community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import travel.travel_community.entity.UserProfile;
import travel.travel_community.web.dto.MyPageDTO;
import travel.travel_community.web.dto.UserAddressDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    //Optional<UserProfile> findByUserId(Long userId);

//    @Query(value = "SELECT up.user_id AS userId, up.sns_address AS currentAddresses, " +
//            "sa.addresses AS newAddresses FROM user_profiles up " +
//            "JOIN (SELECT user_id, GROUP_CONCAT(DISTINCT address SEPARATOR ',') AS addresses " +
//            "FROM sns_addresses WHERE user_id = :userId GROUP BY user_id) sa " +
//            "ON up.user_id = sa.user_id WHERE up.user_id = :userId", nativeQuery = true)
//    Optional<UserAddressDTO> findUserAddressesByUserId(@Param("userId") Long userId);

    @Query("SELECT up FROM UserProfile up WHERE up.user.id = :userId")
    Optional<UserProfile> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT GROUP_CONCAT(DISTINCT address SEPARATOR ',') AS addresses " +
            "FROM sns_addresses WHERE user_id = :userId", nativeQuery = true)
    Optional<String> findSnsAddressesByUserId(@Param("userId") Long userId);
}
