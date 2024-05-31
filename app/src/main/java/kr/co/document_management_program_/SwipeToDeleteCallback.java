package kr.co.document_management_program_;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
    private DocumentAdapter adapter;
    private DocumentViewModel documentViewModel;

    public SwipeToDeleteCallback(DocumentAdapter adapter, DocumentViewModel documentViewModel) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
        this.documentViewModel = documentViewModel;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        Document document = adapter.getDocumentAt(position);
        documentViewModel.delete(document);  // ViewModel을 통해 문서를 삭제
        adapter.deleteItem(position);       // 어댑터에서도 문서를 삭제
    }
}
