package com.example.controller;

import com.example.model.Person;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

@Controller
public class HelloController {

    @Inject
    @Client("/")
    private HttpClient httpClient;

    @Get("/ping")
	public String getData() {

        String retrive =  httpClient.toBlocking().retrieve(HttpRequest.GET("https://www.youtube.com/"));

		return retrive;
	}

    @Post(value = "/record",consumes = MediaType.APPLICATION_JSON,produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> createPerson(final Person person){

        person.setAge(22);
        return HttpResponse.created(person);
    }
}
