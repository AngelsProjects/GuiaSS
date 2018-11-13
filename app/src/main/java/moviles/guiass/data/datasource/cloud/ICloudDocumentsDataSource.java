package moviles.guiass.data.datasource.cloud;

import java.util.List;

import moviles.guiass.data.models.Document;
import moviles.guiass.utils.DocumentCriteria;

public interface ICloudDocumentsDataSource {

    interface DocumentServiceCallback {
        void onLoaded(List<Document> documents);

        void onError(String error);
    }

    void getDocuments(DocumentServiceCallback callback, DocumentCriteria criteria);

}
