package putout.thebest.realm.RESTfulAPI;

import putout.thebest.realm.RESTfulAPI.response.Difficulty;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by daffer on 2017/10/22.
 */

public interface ApiStore {

    String BASE_URL="https://twinword-word-graph-dictionary.p.mashape.com/";

    @Headers(
            {"X-Mashape-Key: BI1Up3HteCmshv0pKX1zIOuBhtCup1KImAEjsn7HMnV7L30NaR",
            "Accept: application/json"}
    )


    @GET("difficulty/")
    Observable<Difficulty> checkDifficulty(@Query("entry") String word);
}
