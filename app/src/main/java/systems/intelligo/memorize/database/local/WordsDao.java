package systems.intelligo.memorize.database.local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import systems.intelligo.memorize.database.entity.Words;

@Dao
public interface WordsDao {

    @Query("SELECT * FROM words")
    List<Words> getWords();

    @Query("SELECT * FROM words WHERE id = :wordId")
    Words getWordById(String wordId);

    @Query("SELECT * FROM words WHERE character = :wordCharacter")
    Words getWordByChar(String wordCharacter);

    @Query("SELECT * FROM words WHERE :condition = :value")
    List<Words> selectWord(String condition, String value);

    @Query("SELECT * FROM words WHERE character = :wordCharacter AND kanji = :kanji")
    Words checkCharKanji(String wordCharacter, String kanji);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWord(Words word);

    @Update
    int updateWord(Words word);

    @Query("UPDATE words SET favorited = :favorited, local = :isLocal WHERE id = :wordId")
    void updateFavorited(String wordId, boolean favorited, boolean isLocal);

    @Query("UPDATE words SET memorized = :memorized, local = :isLocal WHERE id = :wordId")
    void updateMemorized(String wordId, boolean memorized, boolean isLocal);

    @Query("DELETE FROM words")
    void deleteWords();

    @Query("DELETE FROM Words WHERE id = :wordId")
    int deleteWordById(String wordId);

}