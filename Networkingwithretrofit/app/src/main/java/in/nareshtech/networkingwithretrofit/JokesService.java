package in.nareshtech.networkingwithretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JokesService
{
    @GET("random")
    Call<Source> getData();
}
