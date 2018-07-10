package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    TimeEntryRepository Tentry;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.Tentry=timeEntryRepository;
    }



    //@Autowired
    //InMemoryTimeEntryRepository inMemory;
    InMemoryTimeEntryRepository inMemory = new InMemoryTimeEntryRepository();

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
       // return inMemory.create(timeEntryToCreate);

        return new ResponseEntity<TimeEntry>(Tentry.create(timeEntryToCreate), HttpStatus.CREATED);
    }
    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") Long id) {
        TimeEntry tmp = Tentry.find(id);

        return new ResponseEntity<TimeEntry>(tmp, (tmp==null)?HttpStatus.NOT_FOUND :HttpStatus.OK);

    }
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>> ( Tentry.list(), HttpStatus.OK);
    }
    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") Long id,@RequestBody TimeEntry expected) {
        TimeEntry tmp = Tentry.update(id,expected);
        //return new ResponseEntity<TimeEntry>( Tentry.update(l,expected), HttpStatus.NOT_FOUND);
        return new ResponseEntity<TimeEntry>(tmp, (tmp==null)?HttpStatus.NOT_FOUND :HttpStatus.OK);
    }
    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable("id") Long id) {
        Tentry.delete(id);
        return new ResponseEntity<TimeEntry>(Tentry.find(id), HttpStatus.NO_CONTENT);
    }
}
