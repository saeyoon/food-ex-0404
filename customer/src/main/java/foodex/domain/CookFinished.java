package foodex.domain;

import foodex.domain.*;
import foodex.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
}
