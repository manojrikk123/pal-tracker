package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap;
    private long nextTimeEntryId = 1L;

    public InMemoryTimeEntryRepository() {
        timeEntryMap = new HashMap<>();
    }

    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(nextTimeEntryId);
        timeEntryMap.put(nextTimeEntryId, timeEntry);
        return find(nextTimeEntryId++);
    }

    public List<TimeEntry> list() {
        return new ArrayList(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (Objects.isNull(find(id))) {
            return null;
        }

        timeEntry.setId(id);
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return find(id);
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
