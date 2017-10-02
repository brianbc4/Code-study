package info.androidhive.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MoviesResponse extends BaseResponse{
    @SerializedName("results")
    private List<Movie> results;

/*{
   "page":1,
   "total_results":5822,
   "total_pages":292,
   "results":[
   {
         "vote_count":3805,
         "id":129,
         "video":false,
         "vote_average":8.3,
         "title":"Spirited Away",
         "popularity":119.968562,
         "poster_path":"\/ynXoOxmDHNQ4UAy0oU6avW71HVW.jpg",
         "original_language":"ja",
         "original_title":"千と千尋の神隠し",
         "genre_ids":[
            14,
            12,
            16,
            10751
         ],
         "backdrop_path":"\/mnpRKVSXBX6jb56nabvmGKA0Wig.jpg",
         "adult":false,
         "overview":"A ten year old girl who wanders away from her parents along a path that leads to a world ruled by strange and unusual monster-like animals. Her parents have been changed into pigs along with others inside a bathhouse full of these creatures. Will she ever see the world how it once was?",
         "release_date":"2001-07-20"
   },{..},{..}]
} */

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
