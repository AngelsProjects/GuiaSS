package moviles.guiass;

import java.util.List;

import moviles.guiass.data.models.Document;

public interface GuiaSSMvp {

    interface View {
        void showDocuments(List<Document> documents);

        void showLoadingState(boolean show);

        void showEmptyState();

        void showDocumentsError(String msg);
    }

    interface Presenter {
        void loadDocuments(boolean reload);
    }

}
