package moviles.guiass.data.network;

import moviles.guiass.data.models.DocumentResponse;
import moviles.guiass.data.models.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("document")
    Call<DocumentResponse> fetchDocuments();

    @GET("user")
    Call<UserResponse> fetchUsers();
}
