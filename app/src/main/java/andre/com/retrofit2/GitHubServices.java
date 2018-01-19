package andre.com.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andrevieira on 19/01/2018.
 */
//@Path mostrar algum parametro ao retrofit
public interface GitHubServices {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
