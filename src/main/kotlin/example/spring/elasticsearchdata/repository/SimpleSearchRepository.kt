package example.spring.elasticsearchdata.repository

import example.spring.elasticsearchdata.elasticsearch.SimpleSearchEntity
import org.springframework.data.domain.Page
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface SimpleSearchRepository : ElasticsearchRepository<SimpleSearchEntity, String> {
    fun findByNameContains(word: String): List<SimpleSearchEntity>
}