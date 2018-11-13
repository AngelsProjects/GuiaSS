package moviles.guiass.data.datasource.cloud;

import moviles.guiass.data.models.DocumentResponse;
import moviles.guiass.data.network.ApiService;
import moviles.guiass.utils.DocumentCriteria;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CloudDocumentsDataSource implements ICloudDocumentsDataSource {

    public static final String BASE_URL = "url de nuestra api";

    private final Retrofit mRetrofit;
    private final ApiService mRestService;

    public CloudDocumentsDataSource() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRestService = mRetrofit.create(ApiService.class);
    }

    @Override
    public void getDocuments(final DocumentServiceCallback callback, DocumentCriteria criteria) {
        Call<DocumentResponse> call = mRestService.fetchDocuments();

        call.enqueue(new Callback<DocumentResponse>() {
            @Override
            public void onResponse(Call<DocumentResponse> call, Response<DocumentResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    callback.onLoaded(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<DocumentResponse> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

}
