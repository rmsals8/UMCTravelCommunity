package travel.travel_community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.travel_community.entity.SnsAddress;
import travel.travel_community.entity.UserProfile;

import java.util.List;

public interface SnsAddressRepository extends JpaRepository<SnsAddress, Long> {
    List<SnsAddress> findByUserProfile(UserProfile userProfile);
}
