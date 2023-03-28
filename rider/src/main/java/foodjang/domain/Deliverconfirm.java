package foodjang.domain;

import foodjang.domain.*;
import foodjang.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Deliverconfirm extends AbstractEvent {

    private Long id;

    public Deliverconfirm(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverconfirm() {
        super();
    }
}
