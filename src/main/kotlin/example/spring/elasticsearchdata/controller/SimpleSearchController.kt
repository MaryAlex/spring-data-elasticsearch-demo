package example.spring.elasticsearchdata.controller

import example.spring.elasticsearchdata.service.SimpleSearchService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleSearchController(private val simpleSearchService: SimpleSearchService) {
    @GetMapping("/{word}")
    fun contains(@PathVariable word: String) = simpleSearchService.containsWord(word)

    @ResponseStatus(CREATED)
    @PutMapping("/{name}")
    fun createWithName(@PathVariable name: String) = simpleSearchService.createWithName(name)
}