package data.repositories;

import data.models.Entry;

import java.util.List;

public interface EntryRepositories {
    long countEntries();
    void deleteEntry(Entry entry);
    void deleteAllEntries();
    void deleteByIdEntries(long id);
    void saveEntries(Entry entry);
    Entry findEntry(long id);
    boolean existsEntry(long id);
    List<Entry> findAllEntries(String diaryId);
    void saveAllEntries(List<Entry> entries);

}
