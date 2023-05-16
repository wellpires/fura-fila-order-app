package br.com.furafila.orderapp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

public class ApprovedOrderDTODummyBuilder {

	private int itemsAmount;

	public ApprovedOrderDTODummyBuilder itemsAmount(int itemsAmount) {
		this.itemsAmount = itemsAmount;
		return this;
	}

	public List<ApprovedOrderDTO> buildList() {

		List<ApprovedOrderDTO> approvedOrdersDTOs = new ArrayList<>();
		for (int i = 0; i < itemsAmount; i++) {
			ApprovedOrderDTO approvedOrderDTO = new ApprovedOrderDTO();
			approvedOrderDTO.setBucketId(RandomUtils.nextLong());
			approvedOrderDTO.setNumber(RandomStringUtils.randomAlphanumeric(1, 7));
			approvedOrderDTO.setStatusId(RandomUtils.nextLong(1, 9));
			approvedOrderDTO.setStatus(RandomStringUtils.randomAlphabetic(1, 7));
			approvedOrderDTO.setEstablishmentId(RandomUtils.nextLong());
			approvedOrderDTO.setCorporateName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setCnpj(RandomStringUtils.randomNumeric(15));
			approvedOrderDTO.setLockerGroupName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setLockerId(RandomUtils.nextLong());
			approvedOrderDTO.setLockerName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setAddressTypeName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setPostalCode(RandomUtils.nextInt());
			approvedOrderDTO.setAddressName(RandomStringUtils.randomAlphabetic(20));
			approvedOrderDTO.setLatitude(RandomUtils.nextDouble());
			approvedOrderDTO.setLongitude(RandomUtils.nextDouble());
			approvedOrderDTO.setDistrictName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setCityName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setPostalAbbreviation(RandomStringUtils.randomAlphabetic(2).toUpperCase());
			approvedOrderDTO.setCustomerName(RandomStringUtils.randomAlphabetic(30));
			approvedOrderDTO.setCustomerEmail(RandomStringUtils.randomAlphabetic(30));
			approvedOrdersDTOs.add(approvedOrderDTO);

		}

		return approvedOrdersDTOs;
	}

}
