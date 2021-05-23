package example.spring.elasticsearchdata.service

import example.spring.elasticsearchdata.elasticsearch.SimpleSearchEntity
import example.spring.elasticsearchdata.repository.SimpleSearchRepository
import org.springframework.stereotype.Service

@Service
class SimpleSearchService(private val simpleSearchRepository: SimpleSearchRepository ) {
    fun containsWord(word: String) = simpleSearchRepository.findByNameContains(word)
    fun createWithName(name: String) = simpleSearchRepository.save(SimpleSearchEntity(name = name))
}