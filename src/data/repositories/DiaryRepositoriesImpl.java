package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.List;

public class DiaryRepositoriesImpl implements DiaryRepositories {

    @Override
    public long countDiary() {
        return 0;
    }

    @Override
    public void deleteDiary(Entry entry) {

    }

    @Override
    public void deleteAllDiaries() {

    }

    @Override
    public void deleteDiaryById(long id) {

    }

    @Override
    public void saveDiary(Entry entry) {

    }

    @Override
    public void updateDiary(Diary diary) {

    }

    @Override
    public Diary findDiary(long id) {
        return null;
    }

    @Override
    public List<Entry> findAllDiaries(String diaryId) {
        return List.of();
    }
}
