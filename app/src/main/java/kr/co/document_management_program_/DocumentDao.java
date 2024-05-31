package kr.co.document_management_program_;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DocumentDao {
    @Insert
    void insert(Document document);

    @Update
    void update(Document document);

    @Delete
    void delete(Document document);

    @Query("DELETE FROM documents")
    void deleteAllDocuments();

    @Query("SELECT * FROM documents ORDER BY id DESC")
    LiveData<List<Document>> getAllDocuments();
}
