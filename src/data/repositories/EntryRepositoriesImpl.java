package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoriesImpl implements EntryRepositories {
    private List<Entry> entries = new ArrayList<>();


    @Override
    public long countEntries() {
        return entries.size();
    }

    @Override
    public void deleteEntry(Entry entry) {
        entries.remove(entry);}

    @Override
    public void deleteAllEntries() {
        entries.clear();
    }

    @Override
    public void deleteByIdEntries(long id) {
        Entry entry = findEntry(id);
        entries.remove(entry);
    }

    @Override
    public void saveEntries(Entry newEntry) {
        Entry entry = findEntry(newEntry.getId());
        if (entry != null) {
            entries.remove(entry);
            entries.add(newEntry);
        }
        else{
           entries.add(newEntry);
           }
    }

    @Override
    public Entry findEntry(long id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public boolean existsEntry(long id) {
        if (findEntry(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Entry> findAllEntries(String diaryId) {
        List<Entry> result = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getDiaryId().equals(diaryId)) {
                result.add(entry);
            }
        }
        return result;
    }

    @Override
    public void saveAllEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            saveEntries(entry);
        }
    }

}
