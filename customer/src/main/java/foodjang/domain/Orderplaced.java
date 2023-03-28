package foodjang.domain;

import foodjang.domain.*;
import foodjang.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String foodid;
    private String option;
    private String address;

    public Orderplaced(Order aggregate) {
        super(aggregate);
    }

    public Orderplaced() {
        super();
    }
}
