package example.spring.elasticsearchdata.service

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions.Type.ADD
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.support.WriteRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RequestOptions.DEFAULT
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.stereotype.Component
import java.util.Collections
import java.util.UUID
import javax.annotation.PostConstruct

@Component
class PleaseWork(private val highLevelClient: RestHighLevelClient, private val elasticsearchRestTemplate: ElasticsearchRestTemplate) {
    @PostConstruct
    fun index(): IndexRequest {
        // Check if such index exist required
        val simpleIndexRequest = createSimpleIndexRequest()
        highLevelClient.index(simpleIndexRequest, DEFAULT)
        highLevelClient
            .indices()
            .updateAliases(createSimpleAliasRequest(simpleIndexRequest.index()), DEFAULT)
        return simpleIndexRequest
    }

    private fun createSimpleIndexRequest() = IndexRequest(UUID.randomUUID().toString())
        .id(UUID.randomUUID().toString())
        .source(Collections.singletonMap("feature", "high-level-rest-client"))
        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)

    private fun createSimpleAliasRequest(indexName: String) = IndicesAliasesRequest()
        .addAliasAction(simpleIndexAlias(indexName))

    private fun simpleIndexAlias(indexName: String) = IndicesAliasesRequest.AliasActions(ADD)
        .index(indexName)
        .alias("simple_index")
}