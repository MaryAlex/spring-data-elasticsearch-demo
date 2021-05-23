package example.spring.elasticsearchdata.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.elasticsearch.client.ClientConfiguration.builder
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@EnableElasticsearchRepositories(basePackages = ["example.spring.elasticsearchdata.repository"])
@ComponentScan(basePackages = ["example.spring.elasticsearchdata.service"])
class ElasticSearchConfiguration : AbstractElasticsearchConfiguration() {
    @Bean
    override fun elasticsearchClient(): RestHighLevelClient = builder()
        .connectedTo("localhost:9200")
        .build()
        .let { RestClients.create(it) }
        .rest()
}