package io.pivotal.pal.tracker;




import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private static final int indicatorCount = 5;


    private final TimeEntryRepository repository;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepo) {
        this.repository = timeEntryRepo;
    }

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();

        if(repository.list().size() < indicatorCount) {
            builder.up();
        } else {
            builder.down();
        }

        return builder.build();
    }
}


