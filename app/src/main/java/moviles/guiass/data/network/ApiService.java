package moviles.guiass.data.network;

import moviles.guiass.data.models.DocumentResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("document")
    Call<DocumentResponse> fetchDocuments();
}
