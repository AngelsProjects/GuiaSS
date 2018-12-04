package moviles.guiass.data.datasource;

import java.util.List;

import moviles.guiass.data.models.User;
import moviles.guiass.utils.UserCriteria;

public interface IUserRepository {
    interface GetUsersCallback {
        void onUsersLoaded(List<User> users);

        void onDataNotAvailable(String error);
    }

    void getUsers(GetUsersCallback callback, UserCriteria criteria);

    void refreshUsers();
}
