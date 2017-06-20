## MockMVCProveIt

**The goal of this code is to show a simple working example of MockMVC**

The test class in the code demonstrates:

* Spinning up a mock-instance of a spring-boot service
* Returning a response from the service
* Using the [Jackson ObjectMapper](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html) to map the response to a POJO.
* And finally, using a hamcrest mapper with JUnit to assert against the response

```java

@Autowired
protected MockMvc mockMvc;

@Autowired
protected ObjectMapper mapper;

@Test
public void MockMVCSampleTest() throws Exception {

	// use mockMVC to mock the service and run it
	final MvcResult result = mockMvc
			.perform(RestDocumentationRequestBuilders.get("/ProveIt").contentType(MediaType.APPLICATION_JSON))
			.andReturn();

	// use jackson to convert the json response to an entity
	final MockMVCProveItEntity entity = mapper.readValue(result.getResponse().getContentAsString(),
			MockMVCProveItEntity.class);

	// run hamcrest assertion against the mapped entity
	assertThat(entity.getValue(), is(55));
}
```