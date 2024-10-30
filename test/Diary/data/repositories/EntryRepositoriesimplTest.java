package Diary.data.repositories;

import Diary.data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoriesimplTest {
    private EntryRepositoriesimpl entryRepositoriesimpl;
    @BeforeEach
    void setUp() {
        entryRepositoriesimpl = new EntryRepositoriesimpl();
    }


    @Test
    void testThatEntryCreatedIsEmpty() {
    Entry entry = new Entry("title", "conttt");
    entryRepositoriesimpl.addEntry(entry);
    assertNotNull(entry);
    assertEquals(1,entryRepositoriesimpl.size());
    }
    @Test
    void testThatEntryCanBeAdded() {
        Entry entry = new Entry("title", "conttt");
        entryRepositoriesimpl.addEntry(entry);
        assertEquals(1, entryRepositoriesimpl.size());
    }
    @Test
    void testThatEntryCanBeUpdated() {
        Entry entry1 = new Entry("title1", "conttt1");
        Entry entry2 = new Entry("title2", "conttt2");
        entryRepositoriesimpl.addEntry(entry2);
        entryRepositoriesimpl.addEntry(entry1);
        Entry updatedEntry = new Entry("title", "conttt2");
        entryRepositoriesimpl.updateEntry(entry1,updatedEntry);
        assertEquals(entry1,entryRepositoriesimpl.getEntry(updatedEntry.getTitle()));
    }
    @Test
    void testThatEntryUpdatedHasSameId() {
        Entry entry1 = new Entry("title1", "conttt1");
        entryRepositoriesimpl.addEntry(entry1);
        Entry updatedEntry = new Entry("title2", "conttt2");
        entryRepositoriesimpl.updateEntry(entry1,updatedEntry);
        assertEquals(entry1,entryRepositoriesimpl.getEntry(updatedEntry.getTitle()));
        assertEquals(1,entry1.getId());
    }
    @Test
    void testThatMultipleEntriesCanBeAdded() {
        Entry entry1 = new Entry("title1", "conttt1");
        Entry entry2 = new Entry("title2", "conttt2");
        Entry entry3 = new Entry("title3", "conttt3");
        entryRepositoriesimpl.addEntry(entry1);
        entryRepositoriesimpl.addEntry(entry2);
        entryRepositoriesimpl.addEntry(entry3);
        assertEquals(3,entryRepositoriesimpl.size());
        assertEquals("title1",entry1.getTitle());
        assertEquals("title2",entry2.getTitle());
        assertEquals("title3",entry3.getTitle());
    }
    @Test
    void testThatCanGetEntry() {
        Entry entry1 = new Entry("title1", "conttt1");
        Entry entry2 = new Entry("title2", "conttt2");
        Entry entry3 = new Entry("title3", "conttt3");
        entryRepositoriesimpl.addEntry(entry1);
        entryRepositoriesimpl.addEntry(entry2);
        entryRepositoriesimpl.addEntry(entry3);
        assertEquals(entry1,entryRepositoriesimpl.getEntry("title1"));
    }
    @Test
    void testThatEntryCanBeRemoved() {
        Entry entry1 = new Entry("title1", "conttt1");
        Entry entry2 = new Entry("title2", "conttt2");
        Entry entry3 = new Entry("title3", "conttt3");
        entryRepositoriesimpl.addEntry(entry1);
        entryRepositoriesimpl.addEntry(entry2);
        entryRepositoriesimpl.addEntry(entry3);
        entryRepositoriesimpl.deleteEntry("title2");
        assertEquals(2,entryRepositoriesimpl.size());
        assertFalse(entryRepositoriesimpl.contains(entry2));
    }
    @Test
    void testToDeleteAllEntries() {
        Entry entry1 = new Entry("title1", "conttt1");
        Entry entry2 = new Entry("title2", "conttt2");
        Entry entry3 = new Entry("title3", "conttt3");
        entryRepositoriesimpl.addEntry(entry1);
        entryRepositoriesimpl.addEntry(entry2);
        entryRepositoriesimpl.addEntry(entry3);
        entryRepositoriesimpl.deleteAllEntries();
        assertEquals(0,entryRepositoriesimpl.size());

    }
}