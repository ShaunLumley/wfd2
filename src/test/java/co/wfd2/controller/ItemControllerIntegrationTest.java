package co.wfd2.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import co.wfd2.service.SNTEService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SNTEController.class)
@WebAppConfiguration
public class ItemControllerIntegrationTest {

	private static final String partName = "Test Part";
	private static final String nsn = "12345";
	private static final String partNo = "ABC123";

	private List<co.wfd2.service.entity.SNTE> sNTEs;
	
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private SNTEService service;

	@BeforeEach
	public void before() {
		 sNTEs = new ArrayList<>();
		 sNTEs.add(co.wfd2.service.entity.SNTE.builder().nsn(nsn)
					.partName(partName)
					.parentNo(partNo)
					.build());
	}
	
	@Test
	public void givenItems_whenGetItems_thenReturnJsonArray() throws Exception {

		List<co.wfd2.service.entity.SNTE> allItems = sNTEs;

		given(service.get()).willReturn(allItems);

		mvc.perform(get("/sNTEs").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(nsn)));
	}

	@Test
	public void givenNsn_whenGetItem_thenReturnJsonArray() throws Exception {

		given(service.get(nsn)).willReturn(sNTEs);

		mvc.perform(get("/sNTEs/nsn/" + nsn).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(nsn)))
				.andExpect(content().string(containsString(partName)));
	}
}