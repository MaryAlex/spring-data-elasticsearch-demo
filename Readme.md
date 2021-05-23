# Project for Spring Data ElasticSearch  testing
Just a simple project to understand how Spring Data Elasticsearch works, and it's possibilities. 

Something can be done better, something in another way, it is just test, so I didn't check for best practises here :)

## Elasticsearch
To run elasticsearch locally you can use 
`docker run -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.12.1`

To check existed indices `http://localhost:9200/_cat/indices`

To get info for index `http://localhost:9200/[index_name_here]?pretty` 

To get data in index `http://localhost:9200/[index_name_here]/_search?pretty`

During local run of elasticsearch there can be problem of readonly mode (By default, Elasticsearch installed goes into read-only mode when you have less than 5% of free disk space). For local testing this two command can help:  
`curl -XPUT -H "Content-Type: application/json" http://localhost:9200/_cluster/settings -d '{ "transient": { "cluster.routing.allocation.disk.threshold_enabled": false } }'`  
`curl -XPUT -H "Content-Type: application/json" http://localhost:9200/_all/_settings -d '{"index.blocks.read_only_allow_delete": null}'`  
But it is better to fix the original issue in production environment instead of these commands :)

## Spring Application
Just run it, actually, no special actions are required. :)

You can change link of elasticsearch in `ElasticSearchConfiguration.kt` file.

Controllers have two endpoints: `get` and `put` - with the same semantics.

To create new document: `curl -X PUT localhost:8080/nameOfDocument`

To search documents by `contains` operation: `curl localhost:8080/nameContains`

## Useful links
[To understands elasticsearch terminology](https://www.elastic.co/blog/what-is-an-elasticsearch-index)   
[Bueldung link with good `Getting Started` article](https://www.baeldung.com/spring-data-elasticsearch-tutorial)   
[One more article with good examples and explanations](https://reflectoring.io/spring-boot-elasticsearch/)  
[Official spring data documentation](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#reference)  
[Video that also helped me](https://www.youtube.com/watch?v=84t_jC3dr3E)