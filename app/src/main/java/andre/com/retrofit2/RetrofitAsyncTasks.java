package andre.com.retrofit2;

import android.os.AsyncTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andrevieira on 19/01/2018.
 */

public class RetrofitAsyncTasks extends AsyncTask<String,Void,List<Repo>>  {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected List<Repo> doInBackground(String... paramns) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubServices services = retrofit.create(GitHubServices.class);
        Call<List<Repo>> getRepositorios = services.listRepos(paramns[0]);
        try{

            List<Repo> repossitorios = getRepositorios.execute().body();

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(List<Repo> repos) {
        super.onPostExecute(repos);
    }
}
