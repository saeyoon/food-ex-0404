package foodex.domain;

import foodex.RiderApplication;
import foodex.domain.DeliveryConfirmed;
import foodex.domain.FoodPicked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        FoodPicked foodPicked = new FoodPicked(this);
        foodPicked.publishAfterCommit();

        DeliveryConfirmed deliveryConfirmed = new DeliveryConfirmed(this);
        deliveryConfirmed.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void pickFood() {}

    public void confirm() {}
}
