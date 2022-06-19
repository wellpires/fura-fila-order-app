package br.com.furafila.orderapp.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.furafila.orderapp.dto.ApprovedOrderDTO;
import br.com.furafila.orderapp.matcher.ZeroValue;
import br.com.furafila.orderapp.response.ApprovedOrdersResponse;
import br.com.furafila.orderapp.service.OrderService;
import br.com.furafila.orderapp.util.ApprovedOrderDTODummyGenerator;
import br.com.furafila.orderapp.util.ReplaceCamelCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class OrderControllerTest {

	private static final String ORDERS_PATH = "/orders";
	private static final String LIST_APPROVED_ORDERS = ORDERS_PATH.concat("");

	@MockBean
	private OrderService orderService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void shouldListApprovedOrders() throws Exception {

		int itemsAmount = 10;
		when(orderService.listApprovedOrders(anyLong()))
				.thenReturn(new ApprovedOrderDTODummyGenerator().itemsAmount(itemsAmount).buildList());

		Long establishmentId = 10l;
		String path = UriComponentsBuilder.fromPath(LIST_APPROVED_ORDERS).queryParam("establishmentId", establishmentId)
				.build().toUriString();

		MvcResult result = mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andDo(print()).andReturn();

		ApprovedOrdersResponse approvedOrdersResponse = mapper.readValue(result.getResponse().getContentAsString(),
				ApprovedOrdersResponse.class);

		List<ApprovedOrderDTO> approvedOrderDTOs = approvedOrdersResponse.getApprovedOrderDTOs();
		assertNotNull(approvedOrderDTOs);
		assertThat(approvedOrderDTOs, hasSize(itemsAmount));

		for (ApprovedOrderDTO approvedOrderDTO : approvedOrderDTOs) {
			assertThat(approvedOrderDTO.getBucketId(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getNumber(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getStatusId(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getStatus(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getEstablishmentId(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getCorporateName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getCnpj(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getLockerGroupName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getLockerId(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getLockerName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getAddressTypeName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getPostalCode(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getAddressName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getLatitude(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getLongitude(), allOf(not(nullValue()), not(ZeroValue.zeroValue())));
			assertThat(approvedOrderDTO.getDistrictName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getCityName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getPostalAbbreviation(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getCustomerName(), not(blankOrNullString()));
			assertThat(approvedOrderDTO.getCustomerEmail(), not(blankOrNullString()));

		}

	}

}
