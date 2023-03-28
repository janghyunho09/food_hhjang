package foodjang.domain;

import foodjang.StoreApplication;
import foodjang.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String foodid;

    private String option;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void startcook() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void finishcook() {
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static void loadOrderImfiorm(Orderplaced orderplaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}
