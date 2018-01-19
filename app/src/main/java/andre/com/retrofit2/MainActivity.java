package andre.com.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        //Forma Sícrona
        /*RetrofitAsyncTasks tasks = new RetrofitAsyncTasks();
        tasks.execute("octocat");
        */


        //Forma Assincrona
        GitHubServices services = retrofit.create(GitHubServices.class);
        Call<List<Repo>> repos = services. listRepos("octocat");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                // Pegar a lista de repositorio no corpo da requisição
                List<Repo> reposResponse = response.body();

                //Pecorrer a lista
                for (Repo user : reposResponse){
                    Log.i( "GitHubServices", user.getmName());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}

