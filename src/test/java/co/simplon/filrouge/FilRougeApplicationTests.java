package co.simplon.filrouge;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FilRougeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then200IsReceived()
			throws ClientProtocolException, IOException {
		// Given
		HttpUriRequest request = new HttpGet( "http://localhost:8080/api/case" );
		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		// Then
		assertThat(
				httpResponse.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_OK));
	}

}
