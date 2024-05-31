package kr.co.document_management_program_;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentHolder> {
    private List<Document> documents = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public DocumentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.document_item, parent, false);
        return new DocumentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentHolder holder, int position) {
        Document currentDocument = documents.get(position);
        holder.textViewTitle.setText(currentDocument.getTitle());
        holder.textViewContent.setText(currentDocument.getContent());
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
        notifyDataSetChanged();
    }

    public Document getDocumentAt(int position) {
        return documents.get(position);
    }

    public void deleteItem(int position) {
        documents.remove(position);
        notifyItemRemoved(position);
    }

    class DocumentHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewContent;

        public DocumentHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewContent = itemView.findViewById(R.id.text_view_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(documents.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Document document);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
