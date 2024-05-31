package kr.co.document_management_program_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private DocumentViewModel documentViewModel;
    private DocumentAdapter documentAdapter;
    private TextView textViewNoDocuments;  // 문서 없음 메시지 텍스트뷰

    private final ActivityResultLauncher<Intent> addDocumentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String title = result.getData().getStringExtra(AddEditDocumentActivity.EXTRA_TITLE);
                    String content = result.getData().getStringExtra(AddEditDocumentActivity.EXTRA_CONTENT);
                    Document document = new Document(title, content);
                    documentViewModel.insert(document);
                    Toast.makeText(this, "Document saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Document not saved", Toast.LENGTH_SHORT).show();
                }
            }
    );

    private final ActivityResultLauncher<Intent> editDocumentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    int id = result.getData().getIntExtra(AddEditDocumentActivity.EXTRA_ID, -1);
                    if (id == -1) {
                        Toast.makeText(this, "Document can't be updated", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String title = result.getData().getStringExtra(AddEditDocumentActivity.EXTRA_TITLE);
                    String content = result.getData().getStringExtra(AddEditDocumentActivity.EXTRA_CONTENT);
                    Document document = new Document(title, content);
                    document.setId(id);
                    documentViewModel.update(document);
                    Toast.makeText(this, "Document updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Document not saved", Toast.LENGTH_SHORT).show();
                }
            }
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttonAddDocument = findViewById(R.id.button_add);
        buttonAddDocument.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEditDocumentActivity.class);
            addDocumentLauncher.launch(intent);
        });

        textViewNoDocuments = findViewById(R.id.text_view_no_documents);  // 문서 없음 메시지 텍스트뷰 초기화

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        documentAdapter = new DocumentAdapter();
        recyclerView.setAdapter(documentAdapter);

        documentViewModel = new ViewModelProvider(this).get(DocumentViewModel.class);
        documentViewModel.getAllDocuments().observe(this, documents -> {
            documentAdapter.setDocuments(documents);
            // 문서 목록이 비어 있는지 확인하고 메시지 표시
            if (documents.isEmpty()) {
                textViewNoDocuments.setVisibility(View.VISIBLE);
            } else {
                textViewNoDocuments.setVisibility(View.GONE);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(documentAdapter, documentViewModel));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
