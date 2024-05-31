package kr.co.document_management_program_;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DocumentViewModel extends AndroidViewModel {
    private DocumentRepository repository;
    private LiveData<List<Document>> allDocuments;

    public DocumentViewModel(@NonNull Application application) {
        super(application);
        repository = new DocumentRepository(application);
        allDocuments = repository.getAllDocuments();
    }

    public void insert(Document document) {
        repository.insert(document);
    }

    public void update(Document document) {
        repository.update(document);
    }

    public void delete(Document document) {
        repository.delete(document);  // 삭제 메서드 추가
    }

    public LiveData<List<Document>> getAllDocuments() {
        return allDocuments;
    }
}
