package foodjang.domain;

import foodjang.domain.*;
import foodjang.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;

    public CookFinished(Cook aggregate) {
        super(aggregate);
    }

    public CookFinished() {
        super();
    }
}
