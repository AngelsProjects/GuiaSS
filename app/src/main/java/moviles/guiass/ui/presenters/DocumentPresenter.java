package moviles.guiass.ui.presenters;

import java.util.List;

import moviles.guiass.GuiaSSMvp;
import moviles.guiass.data.datasource.DocumentsRepository;
import moviles.guiass.data.models.Document;
import moviles.guiass.utils.DocumentCriteria;
import moviles.guiass.utils.DocumentsPerUserCriteria;

import static com.google.common.base.Preconditions.checkNotNull;

public class DocumentPresenter implements GuiaSSMvp.DocumentPresenter {
    private final DocumentsRepository mDocumentsRepository;
    private final GuiaSSMvp.View mDocumentsView;

    public static final int DOCUMENTS_LIMIT = 20;

    private boolean isFirstLoad = true;
    private int mCurrentPage = 1;

    public DocumentPresenter(DocumentsRepository mDocumentsRepository,
                             GuiaSSMvp.View mDocumentsView) {
        this.mDocumentsRepository = checkNotNull(mDocumentsRepository);
        this.mDocumentsView = checkNotNull(mDocumentsView);
    }

    @Override
    public void loadDocuments(final boolean reload) {
        final boolean reallyReload = reload || isFirstLoad;

        if (reallyReload) {
            mDocumentsView.showLoadingState(true);
            mDocumentsRepository.refreshDocuments();
            mCurrentPage = 1;
        } else {
            mDocumentsView.showLoadMoreIndicator(true);
            mCurrentPage++;
        }

        // Ahora, preparamos el criterio de paginación
        DocumentsPerUserCriteria criteria = new DocumentsPerUserCriteria();

        mDocumentsRepository.getDocuments(
                new DocumentsRepository.GetDocumentsCallback() {
                    @Override
                    public void onDocumentsLoaded(List<Document> documents) {
                        mDocumentsView.showLoadingState(false);
                        processDocuments(documents, reallyReload);

                        // Ahora si, ya no es el primer carga
                        isFirstLoad = false;
                    }

                    @Override
                    public void onDataNotAvailable(String error) {
                        mDocumentsView.showLoadingState(false);
                        mDocumentsView.showLoadMoreIndicator(false);
                        mDocumentsView.showError(error);
                    }
                },
                criteria);

    }

    private void processDocuments(List<Document> documents, boolean reload) {
        if (documents.isEmpty()) {
            if (reload) {
                mDocumentsView.showEmptyState();
            } else {
                mDocumentsView.showLoadMoreIndicator(false);
            }
            mDocumentsView.allowMoreData(false);
        } else {
            if (reload) {
                mDocumentsView.showDocuments(documents);
            } else {
                mDocumentsView.showLoadMoreIndicator(false);
                mDocumentsView.showDocuments(documents);
            }

            mDocumentsView.allowMoreData(true);
        }
    }
}
