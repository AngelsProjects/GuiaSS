package moviles.guiass;

import java.util.List;

import moviles.guiass.data.models.Document;
import moviles.guiass.data.models.User;

public interface GuiaSSMvp {

    interface View {

        void showDocuments(List<Document> documents);

        void showUsers(List<User> users);

        void showLoadingState(boolean show);

        void showLoadMoreIndicator(boolean show);

        void showEmptyState();

        void showError(String msg);

        void allowMoreData(boolean show);
    }

    interface DocumentPresenter {
        void loadDocuments(boolean reload);

    }

    interface UserPresenter {
        void loadUsers(boolean reload);
    }

}
