package br.com.furafila.orderapp.dao.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.com.furafila.orderapp.dao.OrderDAO;
import br.com.furafila.orderapp.dao.mapper.ApprovedOrderDTORowMapper;
import br.com.furafila.orderapp.dto.ApprovedOrderDTO;
import br.com.furafila.orderapp.matcher.ZeroValue;
import br.com.furafila.orderapp.util.ApprovedOrderDTODummyGenerator;
import br.com.furafila.orderapp.util.ReplaceCamelCase;

@DisplayNameGeneration(ReplaceCamelCase.class)
@ExtendWith(MockitoExtension.class)
public class OrderDAOImplTest {

	@InjectMocks
	private OrderDAO productDAO = new OrderDAOImpl();

	@Mock
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Test
	public void shouldListApprovedOrders() {

		int itemsAmount = 10;
		List<ApprovedOrderDTO> approvedOrderDTOs = new ApprovedOrderDTODummyGenerator().itemsAmount(itemsAmount)
				.buildList();
		when(jdbcTemplate.query(anyString(), any(MapSqlParameterSource.class), any(ApprovedOrderDTORowMapper.class)))
				.thenReturn(approvedOrderDTOs);

		List<ApprovedOrderDTO> listApprovedOrders = productDAO.listApprovedOrders(10l);

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
