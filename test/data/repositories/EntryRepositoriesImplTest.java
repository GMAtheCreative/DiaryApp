package data.repositories;

import data.models.Entry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoriesImplTest {
    private final EntryRepositoriesImpl entryRepositories = new EntryRepositoriesImpl();

    @Test
    void testThatEntriesCanBeSaved() {
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());
    }
    @Test
    void testThatEntrySavedCanBeDeleted() {
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());
        entryRepositories.deleteEntry(entry);
        assertEquals(0,entryRepositories.countEntries());
    }
    @Test
    void testThatEntriesCanBeUpdated() {
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());
        entry.setTitle("updatedTitle");
        entry.setContent("updatedContent");
        entry.setId(entry.getId());
        entry.setDiaryId(entry.getDiaryId());
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());
        assertEquals("updatedTitle",entry.getTitle());
    }
    @Test
    void testThatCanFindEntryById (){
        Entry entry = new Entry(); //1
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());

        Entry entry1 = new Entry(); //2
        entry1.setTitle("title1");
        entry1.setContent("content1");
        entry1.setId(2);
        entry1.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry1);
        assertEquals(2,entryRepositories.countEntries());

        Entry entry2 = new Entry();//3
        entry2.setTitle("title2");
        entry2.setContent("content2");
        entry2.setId(3);
        entry2.setDiaryId("diaryId2");
        entryRepositories.saveEntries(entry2);
        assertEquals(3,entryRepositories.countEntries());

        Entry foundEntry = entryRepositories.findEntry(2);
        assertEquals(entry1.getTitle(),foundEntry.getTitle());

    }
    @Test
    void testThatCanDeleteById (){
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());

        Entry entry1 = new Entry();
        entry1.setTitle("title1");
        entry1.setContent("content1");
        entry1.setId(2);
        entry1.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry1);
        assertEquals(2,entryRepositories.countEntries());

        Entry entry2 = new Entry();
        entry2.setTitle("title2");
        entry2.setContent("content2");
        entry2.setId(3);
        entry2.setDiaryId("diaryId2");
        entryRepositories.saveEntries(entry2);
        assertEquals(3,entryRepositories.countEntries());

        entryRepositories.deleteByIdEntries(2);
        assertEquals(2,entryRepositories.countEntries());
        assertEquals(null,entryRepositories.findEntry(2));
    }
    @Test
    void testToDeleteAllEntries (){
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());

        Entry entry1 = new Entry();
        entry1.setTitle("title1");
        entry1.setContent("content1");
        entry1.setId(2);
        entry1.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry1);
        assertEquals(2,entryRepositories.countEntries());

        Entry entry2 = new Entry();
        entry2.setTitle("title2");
        entry2.setContent("content2");
        entry2.setId(3);
        entry2.setDiaryId("diaryId2");
        entryRepositories.saveEntries(entry2);
        assertEquals(3,entryRepositories.countEntries());

        entryRepositories.deleteAllEntries();
        assertEquals(0,entryRepositories.countEntries());

    }
    @Test
    void testToCheckIfEntryExistById (){
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setContent("content");
        entry.setId(1);
        entry.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry);
        assertEquals(1,entryRepositories.countEntries());

        Entry entry1 = new Entry();
        entry1.setTitle("title1");
        entry1.setContent("content1");
        entry1.setId(2);
        entry1.setDiaryId("diaryId1");
        entryRepositories.saveEntries(entry1);
        assertEquals(2,entryRepositories.countEntries());

        Entry entry2 = new Entry();
        entry2.setTitle("title2");
        entry2.setContent("content2");
        entry2.setId(3);
        entry2.setDiaryId("diaryId2");
        entryRepositories.saveEntries(entry2);
        assertEquals(3,entryRepositories.countEntries());

        assertTrue(entryRepositories.existsEntry(2));
    }
    @Test
    void testToAddAllEntries() {
        Entry entry1 = new Entry();
        entry1.setTitle("title1");
        entry1.setContent("content1");
        entry1.setId(1);
        entry1.setDiaryId("diaryId1");

        Entry entry2 = new Entry();
        entry2.setTitle("title2");
        entry2.setContent("content2");
        entry2.setId(2);
        entry2.setDiaryId("diaryId1");

        Entry entry3 = new Entry();
        entry3.setTitle("title3");
        entry3.setContent("content3");
        entry3.setId(3);
        entry3.setDiaryId("diaryId1");

        Entry entry4 = new Entry();
        entry4.setTitle("title4");
        entry4.setContent("content4");
        entry4.setId(4);
        entry4.setDiaryId("diaryId1");

        Entry[] entries = {entry1, entry2, entry3, entry4};
        entryRepositories.saveAllEntries(List.of(entries));
        assertEquals(4, entryRepositories.countEntries());
        assertTrue(entryRepositories.existsEntry(2));
    }
    @Test
    void testToFindAllEntriesByDiaryId (){
        Entry entry1 = new Entry();
        entry1.setTitle("title1");
        entry1.setContent("content1");
        entry1.setId(1);
        entry1.setDiaryId("diaryId1");

        Entry entry2 = new Entry();
        entry2.setTitle("title2");
        entry2.setContent("content2");
        entry2.setId(2);
        entry2.setDiaryId("diaryId2");

        Entry entry3 = new Entry();
        entry3.setTitle("title3");
        entry3.setContent("content3");
        entry3.setId(3);
        entry3.setDiaryId("diaryId3");

        Entry entry4 = new Entry();
        entry4.setTitle("title4");
        entry4.setContent("content4");
        entry4.setId(4);
        entry4.setDiaryId("diaryId1");

        Entry[] entries = {entry1, entry2, entry3, entry4};
        entryRepositories.saveAllEntries(List.of(entries));
        assertEquals(4, entryRepositories.countEntries());

        List <Entry> expected = List.of(entry1,entry4);
        assertEquals(expected, entryRepositories.findAllEntries("diaryId1"));
    }
}