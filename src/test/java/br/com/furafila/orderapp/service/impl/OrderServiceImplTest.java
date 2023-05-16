package br.com.furafila.orderapp.service.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.furafila.orderapp.dao.OrderDAO;
import br.com.furafila.orderapp.dto.ApprovedOrderDTO;
import br.com.furafila.orderapp.matcher.ZeroValue;
import br.com.furafila.orderapp.service.OrderService;
import br.com.furafila.orderapp.util.ApprovedOrderDTODummyBuilder;
import br.com.furafila.orderapp.util.ReplaceCamelCase;

@DisplayNameGeneration(ReplaceCamelCase.class)
@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();

	@Mock
	private OrderDAO orderDAO;

	@Test
	public void shouldListApprovedOrders() {

		int itemsAmount = 10;
		List<ApprovedOrderDTO> approvedOrderDTOs = new ApprovedOrderDTODummyBuilder().itemsAmount(itemsAmount)
				.buildList();
		when(orderDAO.listApprovedOrders(anyLong())).thenReturn(approvedOrderDTOs);

		List<ApprovedOrderDTO> listApprovedOrders = orderService.listApprovedOrders(10l);

		assertNotNull(listApprovedOrders);
		assertThat(listApprovedOrders, hasSize(itemsAmount));

		for (ApprovedOrderDTO approvedOrderDTO : listApprovedOrders) {
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
