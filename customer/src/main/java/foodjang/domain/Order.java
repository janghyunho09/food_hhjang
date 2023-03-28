package foodjang.domain;

import foodjang.CustomerApplication;
import foodjang.domain.Orderplaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerid;

    private String foodid;

    private String option;

    private String adrress;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void cancelOrder() {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static void updateStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
