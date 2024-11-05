package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public interface DiaryRepositories {
    long countDiary();
    void deleteDiary(Entry entry);
    void deleteAllDiaries();
    void deleteDiaryById(long id);
    void saveDiary(Entry entry);
    void updateDiary(Diary diary);
    Diary findDiary(long id);
    List<Entry> findAllDiaries(String diaryId);

}

