package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap;
    private long nextTimeEntryId = 1L;

    public InMemoryTimeEntryRepository() {
        timeEntryMap = new HashMap<>();

        /*TimeEntry timeEntry1 = new TimeEntry(1L, 100L, 1001L, LocalDate.parse("2019-11-12"), 8);
        TimeEntry timeEntry2 = new TimeEntry(2L, 100L, 1002L, LocalDate.parse("2019-11-13"), 8);
        TimeEntry timeEntry3 = new TimeEntry(3L, 101L, 1003L, LocalDate.parse("2019-11-14"), 8);
        TimeEntry timeEntry4 = new TimeEntry(4L, 101L, 1004L, LocalDate.parse("2019-11-15"), 8);
        TimeEntry timeEntry5 = new TimeEntry(5L, 100L, 1005L, LocalDate.parse("2019-11-16"), 8);

        timeEntryMap.put(timeEntry1.getId(), timeEntry1);
        timeEntryMap.put(timeEntry2.getId(), timeEntry2);
        timeEntryMap.put(timeEntry3.getId(), timeEntry3);
        timeEntryMap.put(timeEntry4.getId(), timeEntry4);
        timeEntryMap.put(timeEntry5.getId(), timeEntry5);*/
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
