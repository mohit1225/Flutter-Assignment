


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import com.example.news;
import com.example.news.Model.News;
import com.example.news.Model.WebSite;



public interface NewsService {
    @GET("v2/sources?language=en&apiKey="+ Common.API_KEY)
    Call<WebSite> getSources();

    @GET
    Call<News> getNewestArticles(@Url String url);
}