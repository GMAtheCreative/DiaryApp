package Diary.data.repositories;

import Diary.data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoriesimpl implements EntryRepositories {
    long id;
    List<Entry> entries =  new ArrayList<>();

    @Override
    public void addEntry(Entry entry) {
        entry.setId(++id);
        entries.add(entry);
    }

    @Override
    public Entry getEntry(String title) {
        for (Entry entry : entries) {
            if (entry.getTitle().equals(title)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public void updateEntry(Entry oldEntry, Entry newEntry) {
        for (Entry entry : entries) {
            if (entry.getTitle().equals(oldEntry.getTitle())) {
                entry.setTitle(newEntry.getTitle());
                entry.setContent(newEntry.getContent());
            }
        }
    }

    @Override
    public void deleteEntry(String id) {
        for (Entry entry : entries) {
            if (entry.getTitle().equals(id)) {
                entries.remove(entry);
            }
        }
    }

    @Override
    public void deleteAllEntries() {
        entries.clear();
    }

    @Override
    public boolean contains(Entry entry) {
        for (Entry newEntry : entries) {
            if (newEntry.getTitle().equals(entry.getTitle())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long size() {
        return entries.size();
    }


}
