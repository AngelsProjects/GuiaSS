package moviles.guiass.data.datasource;

import java.util.List;

import moviles.guiass.data.models.Document;
import moviles.guiass.utils.DocumentCriteria;

public interface IDocumentsRepository {
    interface GetDocumentsCallback {
        void onDocumentsLoaded(List<Document> documents);
        void onDataNotAvailable(String error);
    }

    void getDocuments(GetDocumentsCallback callback, DocumentCriteria criteria);
    void refreshDocuments();
}
