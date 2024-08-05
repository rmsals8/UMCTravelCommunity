package travel.travel_community.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sns_addresses")
public class SnsAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    private String address;

    @Override
    public String toString() {
        return "SnsAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
