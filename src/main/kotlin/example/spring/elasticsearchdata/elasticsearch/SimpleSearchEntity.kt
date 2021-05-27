package example.spring.elasticsearchdata.elasticsearch

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "simple_index", createIndex = false)
class SimpleSearchEntity(
    @Id val id: String = "",
    val name: String,
)