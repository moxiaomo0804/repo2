package com.thw.elasticsearch.test;

import com.thw.elasticsearch.ItemRepository;
import com.thw.pojo.Item;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ItemRepository itemRepository;
    @Test
    public void testIndex(){
        this.elasticsearchTemplate.createIndex(Item.class);
        this.elasticsearchTemplate.putMapping(Item.class);
    }

    @Test
    public void testCreate(){
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        itemRepository.save(item);
    }
    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }
    @Test
    public void testQuery(){
        Optional<Item> item = this.itemRepository.findById(1l);
        System.out.println(item.get());
    }
    @Test
    public void testFind(){
        // 查询全部，并按照价格降序排序
        Iterable<Item> items = this.itemRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        items.forEach(item-> System.out.println(item));
        //items.forEach(System.out::println);
    }
    @Test
    public void testFindByTitle(){
        List<Item> items = this.itemRepository.findByTitle("手机");
        items.forEach(System.out::println);
    }
    @Test
    public void testFindByPriceBetween(){
        List<Item> items = this.itemRepository.findByPriceBetween(2000.0, 3500d);
        items.forEach(item -> System.out.println(item));
    }
    @Test
    public void indexList2() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.leyou.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.leyou.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }
    @Test
    public void testSearch(){
        //通过查询构建器工具构建查询条件
        MatchQueryBuilder builder = QueryBuilders.matchQuery("title", "手机");
        //执行查询
        Iterable<Item> items = this.itemRepository.search(builder);
        for (Item item : items) {
            System.out.println(item);
        }
    }
    @Test
    public void testNative(){
        //构建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本的查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "手机"));
        //执行查询获得分页结果集
        Page<Item> itemPage = this.itemRepository.search(queryBuilder.build());
        System.out.println(itemPage.getTotalPages());
        System.out.println(itemPage.getTotalElements());
        //itemPage.forEach(System.out::println);
        itemPage.getContent().forEach(System.out::println);
    }
    @Test
    public void testPage(){
        //构建自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本的查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("category", "手机"));
        //分页
        //queryBuilder.withPageable(PageRequest.of(1,2));
        //执行查询获得分页结果集
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        Page<Item> itemPage = this.itemRepository.search(queryBuilder.build());
        System.out.println(itemPage.getTotalPages());
        System.out.println(itemPage.getTotalElements());
        //itemPage.forEach(System.out::println);
        itemPage.getContent().forEach(System.out::println);
    }

    @Test
    public void testAggs(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("brands").field("brand"));
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemRepository.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("brands");
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            // 3.5、获取桶中的文档数量
            System.out.println(bucket.getDocCount());
        }

    }
    @Test
    public void testSubAggs(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("brands").field("brand")
                        .subAggregation(AggregationBuilders.avg("price_avg").field("price")));
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemRepository.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("brands");
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            // 3.5、获取桶中的文档数量
            System.out.println(bucket.getDocCount());
            Map<String, Aggregation> stringAggregationMap = bucket.getAggregations().asMap();
            InternalAvg price_avg = (InternalAvg)stringAggregationMap.get("price_avg");
            System.out.println(price_avg.getValue());

        }

    }
}
