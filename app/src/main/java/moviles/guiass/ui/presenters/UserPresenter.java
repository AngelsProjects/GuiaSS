package moviles.guiass.ui.presenters;

import java.util.List;

import moviles.guiass.GuiaSSMvp;
import moviles.guiass.data.datasource.UserRepository;
import moviles.guiass.data.models.User;
import moviles.guiass.utils.UsersCriteria;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserPresenter implements GuiaSSMvp.UserPresenter {
    private final UserRepository mUserRepository;
    private final GuiaSSMvp.View mUserView;
    private boolean isFirstLoad = true;
    private int mCurrentPage = 1;
    public static final int USERS_LIMITS = 20;

    public UserPresenter(UserRepository mUserRepository,
                         GuiaSSMvp.View mUserView) {
        this.mUserRepository = checkNotNull(mUserRepository);
        this.mUserView = checkNotNull(mUserView);
    }

    private void processUsers(List<User> users, boolean reload) {
        if (users.isEmpty()) {
            if (reload) {
                mUserView.showEmptyState();
            } else {
                mUserView.showLoadMoreIndicator(false);
            }
            mUserView.allowMoreData(false);
        } else {
            if (reload) {
                mUserView.showUsers(users);
            } else {
                mUserView.showLoadMoreIndicator(false);
                mUserView.showUsers(users);
            }

            mUserView.allowMoreData(true);
        }
    }

    @Override
    public void loadUsers(boolean reload) {
        final boolean reallyReload = reload || isFirstLoad;

        if (reallyReload) {
            mUserView.showLoadingState(true);
            mUserRepository.refreshUsers();
            mCurrentPage = 1;
        } else {
            mUserView.showLoadMoreIndicator(true);
            mCurrentPage++;
        }
        UsersCriteria criteria = new UsersCriteria(mCurrentPage, USERS_LIMITS);

        mUserRepository.getUsers(
                new UserRepository.GetUsersCallback() {

                    @Override
                    public void onUsersLoaded(List<User> users) {
                        mUserView.showLoadingState(false);
                        processUsers(users, reallyReload);
                        isFirstLoad = false;
                    }

                    @Override
                    public void onDataNotAvailable(String error) {
                        mUserView.showLoadingState(false);
                        mUserView.showLoadMoreIndicator(false);
                        mUserView.showError(error);
                    }
                },
                criteria);
    }
}
