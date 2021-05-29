//package com.zero.seven.db.util;
//
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchRequestBuilder;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.common.Nullable;
//import org.elasticsearch.index.query.*;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.elasticsearch.search.sort.SortOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ESUtil {
//
//    @Autowired
//    private RestHighLevelClient restHighLevelClient;
//
//    public void search() throws Exception {
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("snake");
//        SearchSourceBuilder builder = new SearchSourceBuilder();//最外层
//        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();//第二层 组合条件
//        MatchPhraseQueryBuilder matchPhraseQueryBuilder =
//                QueryBuilders.matchPhraseQuery("name", "竹叶青");
//        MatchQueryBuilder matchQueryBuilder=QueryBuilders.matchQuery("age",1);
//        boolQueryBuilder.must(matchPhraseQueryBuilder).must(matchQueryBuilder);
//        builder.query(boolQueryBuilder);
//        searchRequest.source(builder);
//        SearchResponse response=restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        builder.sort("age", SortOrder.DESC);
//        builder.from(0).size(10);
//        String[] includes={};
//        String[] excludes={"name","age"};
//        builder.fetchSource(includes,excludes);
//        System.out.println(response.getHits());
//    }
//
//}
