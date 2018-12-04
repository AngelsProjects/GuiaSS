package moviles.guiass.data.datasource.cloud;

import moviles.guiass.data.models.UserResponse;
import moviles.guiass.data.network.ApiService;
import moviles.guiass.utils.UserCriteria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CloudUsersDataSource implements ICloudUsersDataSource {
    public static final String BASE_URL = "https://guiassapi.azurewebsites.net/api/";

    private final Retrofit mRetrofit;
    private final ApiService mRestService;

    public CloudUsersDataSource() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRestService = mRetrofit.create(ApiService.class);
    }

    @Override
    public void getUsers(final UserServiceCallback callback, UserCriteria criteria) {
        Call<UserResponse> call = mRestService.fetchUsers();

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    callback.onLoaded(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
