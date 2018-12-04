package moviles.guiass.data.datasource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import moviles.guiass.data.datasource.cloud.ICloudUsersDataSource;
import moviles.guiass.data.datasource.memory.IMemoryUsersDataSource;
import moviles.guiass.data.models.User;
import moviles.guiass.utils.UserCriteria;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserRepository implements IUserRepository{
    private final IMemoryUsersDataSource mMemoryUsersDataSource;
    private final ICloudUsersDataSource mCloudUsersDataSource;
    private final Context mContext;

    private boolean mReload;

    public UserRepository(IMemoryUsersDataSource memoryDataSource,
                               ICloudUsersDataSource cloudDataSource,
                               Context context) {
        mMemoryUsersDataSource = checkNotNull(memoryDataSource);
        mCloudUsersDataSource = checkNotNull(cloudDataSource);

        mContext = checkNotNull(context);
    }

    @Override
    public void getUsers(GetUsersCallback callback, final UserCriteria criteria) {
        if (true) {
            getUsersFromServer(callback, criteria);
        } else {
            List<User> users = mMemoryUsersDataSource.find(criteria);
            if (users.size() > 0) {
                callback.onUsersLoaded(users);
            } else {
                getUsersFromServer(callback, criteria);
            }
        }
    }

    @Override
    public void refreshUsers() {
        mReload = true;
    }

    private void getUsersFromMemory(GetUsersCallback callback,
                                        UserCriteria criteria) {

        callback.onUsersLoaded(mMemoryUsersDataSource.find(criteria));
    }

    private void getUsersFromServer(final GetUsersCallback callback,
                                        final UserCriteria criteria) {

        if (!isOnline()) {
            callback.onDataNotAvailable("No hay conexión de red.");
            return;
        }

        mCloudUsersDataSource.getUsers(
                new ICloudUsersDataSource.UserServiceCallback() {
                    @Override
                    public void onLoaded(List<User> users) {
                        refreshMemoryDataSource(users);
                        getUsersFromMemory(callback, criteria);
                    }

                    @Override
                    public void onError(String error) {
                        callback.onDataNotAvailable(error);
                    }
                },
                null);
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }

    private void refreshMemoryDataSource(List<User> users) {
        mMemoryUsersDataSource.deleteAll();
        for (User user : users) {
            mMemoryUsersDataSource.save(user);
        }
        mReload = false;
    }
}
