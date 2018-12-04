package moviles.guiass.utils;

import java.util.List;

import moviles.guiass.data.models.User;

public class UsersCriteria implements UserCriteria {
    private final int mPage;
    private final int mLimit;

    public UsersCriteria(int mPage, int mLimit) {
        this.mPage = mPage;
        this.mLimit = mLimit;
    }

    @Override
    public List<User> match(List<User> users) {
        return null;
    }

}
