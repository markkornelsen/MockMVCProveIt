package com.example.MockMVCProveIt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcProveItApplicationTests {

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
}
