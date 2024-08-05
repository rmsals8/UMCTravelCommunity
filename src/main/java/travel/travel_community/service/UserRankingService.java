package travel.travel_community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.travel_community.entity.User;
import travel.travel_community.repository.UserRepository2;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserRankingService {

    @Autowired
    private UserRepository2 userRepository;

    public List<User> getTop30ByJoinDate() {
        return userRepository.findTop30ByOrderByCreatedAtDesc();
    }

    public List<User> getTop30ByLikes() {
        return userRepository.findTop30ByTotalLikes();
    }

    public List<User> getTop30ByScraps() {
        return userRepository.findTop30ByTotalScraps();
    }

    public List<User> getTop30ByPosts() {
        return userRepository.findTop30ByTotalPosts();
    }

    public List<User> getTop30UsersRandomly() {
        Set<User> uniqueUsers = new HashSet<>();
        uniqueUsers.addAll(getTop30ByJoinDate());
        uniqueUsers.addAll(getTop30ByLikes());
        uniqueUsers.addAll(getTop30ByScraps());
        uniqueUsers.addAll(getTop30ByPosts());

        List<User> randomUsers = new ArrayList<>(uniqueUsers);
        Collections.shuffle(randomUsers);

        return randomUsers.stream().limit(30).collect(Collectors.toList());
    }
}