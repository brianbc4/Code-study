package putout.thebest.realm.RESTfulAPI;

import putout.thebest.realm.Retrofit.SimpleRetrofit;
import retrofit2.Retrofit;

/**
 * Created by daffer on 2017/10/22.
 */

public class NetWorkService {

    private static NetWorkService INSTANCE;

    private ApiStore apiStore;

    public static NetWorkService getInstance(){
        return INSTANCE != null ? INSTANCE : (INSTANCE = new NetWorkService());
    }

    private NetWorkService(){
       Retrofit retrofit = SimpleRetrofit.getInstance().build(ApiStore.BASE_URL);

        apiStore = retrofit.create(ApiStore.class);
    }


    public ApiStore getApiStore(){
        return INSTANCE.apiStore;
    }

}
