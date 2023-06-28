package hexagonal.architecture.shared.infrastructure.config;

import hexagonal.architecture.shared.domain.ClockProvider;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZoneOffset;

@Service
public class BeanClock implements ClockProvider {
    @Override
    public Clock clock() {
        return Clock.fixed(Clock.systemUTC().instant(), ZoneOffset.UTC);
    }
}
