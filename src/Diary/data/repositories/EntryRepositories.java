package Diary.data.repositories;

import Diary.data.models.Entry;

public interface EntryRepositories {
    void addEntry(Entry entry);
    Entry getEntry(String title);
    void updateEntry(Entry oldEntry, Entry newEntry);
    void deleteEntry(String id);
    void deleteAllEntries();
    boolean contains(Entry entry);

    long size();
}
