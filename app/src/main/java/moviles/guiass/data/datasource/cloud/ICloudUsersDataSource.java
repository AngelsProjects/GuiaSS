package moviles.guiass.data.datasource.cloud;

import java.util.List;

import moviles.guiass.data.models.User;
import moviles.guiass.utils.UserCriteria;

public interface ICloudUsersDataSource {
    interface UserServiceCallback {
        void onLoaded(List<User> users);

        void onError(String error);
    }

    void getUsers(ICloudUsersDataSource.UserServiceCallback callback, UserCriteria criteria);

}
