package mts.actual.services.help.broker;

import mts.actual.services.help.view.SupportRequest;

public interface Publisher {
    String offer(SupportRequest request);
}
