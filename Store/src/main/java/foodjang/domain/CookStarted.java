package foodjang.domain;

import foodjang.domain.*;
import foodjang.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderid;

    public CookStarted(Cook aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}
