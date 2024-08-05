// 추가한 부분
package travel.travel_community.entity;

import jakarta.persistence.*;
import lombok.*;
import travel.travel_community.entity.baseEntity.TimeEntity;
import travel.travel_community.web.controller.TravelPost;

@Entity
@Table(name = "travel_post_scraps")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TravelPostScrap extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private TravelPost post;
}