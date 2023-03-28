package foodjang.domain;

import foodjang.domain.*;
import foodjang.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FoodPicked extends AbstractEvent {

    private Long id;

    public FoodPicked(Delivery aggregate) {
        super(aggregate);
    }

    public FoodPicked() {
        super();
    }
}
