package kr.co.document_management_program_;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Document.class}, version = 1)
public abstract class DocumentDatabase extends RoomDatabase {
    private static DocumentDatabase instance;

    public abstract DocumentDao documentDao();

    public static synchronized DocumentDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            DocumentDatabase.class, "document_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
