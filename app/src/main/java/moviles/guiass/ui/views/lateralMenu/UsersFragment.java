package moviles.guiass.ui.views.lateralMenu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moviles.guiass.GuiaSSMvp;
import moviles.guiass.data.models.Document;
import moviles.guiass.data.models.User;
import moviles.guiass.di.DependencyProvider;
import moviles.guiass.ui.MainActivity;
import moviles.guiass.ui.R;
import moviles.guiass.ui.presenters.UserPresenter;

public class UsersFragment extends Fragment implements GuiaSSMvp.View, View.OnClickListener {

    private UserPresenter mUsersPresenter;
    @BindView(R.id.button)
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ButterKnife.bind(this, view);
        mUsersPresenter = new UserPresenter(
                DependencyProvider.provideUsersRepository(getActivity()),
                this);
        mUsersPresenter.loadUsers(true);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showDocuments(List<Document> documents) {

    }

    @Override
    public void showUsers(List<User> users) {
        System.out.println("Hello world!");
    }

    @Override
    public void showLoadingState(boolean show) {

    }

    @Override
    public void showLoadMoreIndicator(boolean show) {

    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void allowMoreData(boolean show) {

    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).changeFragment(new UserInfoFragment(), true);
    }
}
