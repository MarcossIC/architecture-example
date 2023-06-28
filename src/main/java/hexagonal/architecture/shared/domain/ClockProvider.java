package hexagonal.architecture.shared.domain;

import java.time.Clock;

public interface ClockProvider {
    Clock clock();
}
