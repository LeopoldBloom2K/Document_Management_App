package kr.co.document_management_program_;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DocumentRepository {
    private DocumentDao documentDao;
    private LiveData<List<Document>> allDocuments;
    private ExecutorService executorService;

    public DocumentRepository(Application application) {
        DocumentDatabase database = DocumentDatabase.getInstance(application);
        documentDao = database.documentDao();
        allDocuments = documentDao.getAllDocuments();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void insert(Document document) {
        executorService.execute(() -> documentDao.insert(document));
    }

    public void update(Document document) {
        executorService.execute(() -> documentDao.update(document));
    }

    public void delete(Document document) {
        executorService.execute(() -> documentDao.delete(document));
    }

    public void deleteAllDocuments() {
        executorService.execute(documentDao::deleteAllDocuments);
    }

    public LiveData<List<Document>> getAllDocuments() {
        return allDocuments;
    }
}
