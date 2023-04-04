package foodex.domain;

import foodex.domain.*;
import foodex.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String foodid;
    private String option;
    private String address;
}
