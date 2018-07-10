package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap repos = new HashMap();
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        //return null;
        timeEntry.setId(repos.size()+1);
        repos.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return (TimeEntry) repos.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return (List<TimeEntry>) new ArrayList<TimeEntry>(repos.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (repos.containsKey(id)) {
            return (TimeEntry) repos.put(id, timeEntry);
        } else {
            return null;
        }
    }


    @Override
    public void delete(Long id) {
        repos.remove(id);
    }
}
