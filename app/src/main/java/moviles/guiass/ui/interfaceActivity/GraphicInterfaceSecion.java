package moviles.guiass.ui.interfaceActivity;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import moviles.guiass.GuiaSSMvp;
import moviles.guiass.data.models.Document;
import moviles.guiass.data.models.User;
import moviles.guiass.di.DependencyProvider;
import moviles.guiass.ui.R;
import moviles.guiass.ui.presenters.UserPresenter;

public class GraphicInterfaceSecion extends AppCompatActivity implements GuiaSSMvp.View {
    private UserPresenter mUsersPresenter;
    // private UsersAdapter mUsersAdapter;

    // @BindView(R.id.users_list)
    //  RecyclerView mUsersList;
    //  @BindView(R.id.noUsers)
    //  View mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   mUsersAdapter = new UsersAdapter(new ArrayList<User>(0), mItemListener);
        setContentView(R.layout.activity_graphic_interface_secion);
        mUsersPresenter = new UserPresenter(
                DependencyProvider.provideUsersRepository(getApplicationContext()),
                this);
        mUsersPresenter.loadUsers(true);

        // Setup
        //     setUpUsersList();
        //   setUptRefreshLayout();
    }

    /*
        private UsersAdapter.UserItemListener mItemListener = new UsersAdapter.UserItemListener() {
            @Override
            public void onUserClick(User clickedUser) {
            }
        };

        private void setUpUsersList() {
            mUsersList.setAdapter(mUsersAdapter);
            mUsersList.setHasFixedSize(true);

            final GridLayoutManager layoutManager =
                    (GridLayoutManager) mUsersList.getLayoutManager();

            // Se agrega escucha de scroll infinito.
            mUsersList.addOnScrollListener(
                    new InfinityScrollListener(mUsersAdapter, layoutManager) {
                        @Override
                        public void onLoadMore() {
                            mUsersPresenter.loadUsers(false);
                        }
                    });
        }

        private void setUptRefreshLayout() {
            mSwipeRefreshLayout.setColorSchemeColors(
                    ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                    ContextCompat.getColor(getActivity(), R.color.colorAccent),
                    ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));

            mSwipeRefreshLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            mUsersPresenter.loadUsers(true);
                        }
                    });
        }
    */
    @Override
    public void showDocuments(List<Document> documents) {

    }

    @Override
    public void showUsers(List<User> users) {
        //      mUsersAdapter.replaceData(users);
        hideList(false);
    }

    private void hideList(boolean hide) {
        //    mUsersList.setVisibility(hide ? View.GONE : View.VISIBLE);
        //   mEmptyView.setVisibility(hide ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showLoadingState(boolean show) {

    }

    @Override
    public void showLoadMoreIndicator(boolean show) {
        if (!show) {
            //     mUsersAdapter.dataFinishedLoading();
        } else {
            //      mUsersAdapter.dataStartedLoading();
        }
    }

    @Override
    public void showEmptyState() {
        //  mUsersList.setVisibility(View.GONE);
        //   mEmptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void allowMoreData(boolean show) {
        //   mUsersAdapter.setMoreData(show);
    }

}
