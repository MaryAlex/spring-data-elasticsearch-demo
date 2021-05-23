package example.spring.elasticsearchdata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElasticsearchDataApplication

fun main(args: Array<String>) {
	runApplication<ElasticsearchDataApplication>(*args)
}
