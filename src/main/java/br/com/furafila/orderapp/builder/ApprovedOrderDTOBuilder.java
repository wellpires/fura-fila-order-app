package br.com.furafila.orderapp.builder;

import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

public class ApprovedOrderDTOBuilder {

	private Long bucketId;
	private String number;
	private Long statusId;
	private String status;
	private Long establishmentId;
	private String corporateName;
	private String cnpj;
	private String lockerGroupName;
	private Long lockerId;
	private String lockerName;
	private String addressTypeName;
	private Integer postalCode;
	private String addressName;
	private Double latitude;
	private Double longitude;
	private String districtName;
	private String cityName;
	private String postalAbbreviation;
	private String customerName;
	private String customerEmail;

	public ApprovedOrderDTOBuilder bucketId(Long bucketId) {
		this.bucketId = bucketId;
		return this;
	}

	public ApprovedOrderDTOBuilder number(String number) {
		this.number = number;
		return this;
	}

	public ApprovedOrderDTOBuilder statusId(Long statusId) {
		this.statusId = statusId;
		return this;
	}

	public ApprovedOrderDTOBuilder status(String status) {
		this.status = status;
		return this;
	}

	public ApprovedOrderDTOBuilder establishmentId(Long establishmentId) {
		this.establishmentId = establishmentId;
		return this;
	}

	public ApprovedOrderDTOBuilder corporateName(String corporateName) {
		this.corporateName = corporateName;
		return this;
	}

	public ApprovedOrderDTOBuilder cnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public ApprovedOrderDTOBuilder lockerGroupName(String lockerGroupName) {
		this.lockerGroupName = lockerGroupName;
		return this;
	}

	public ApprovedOrderDTOBuilder lockerId(Long lockerId) {
		this.lockerId = lockerId;
		return this;
	}

	public ApprovedOrderDTOBuilder lockerName(String lockerName) {
		this.lockerName = lockerName;
		return this;
	}

	public ApprovedOrderDTOBuilder addressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
		return this;
	}

	public ApprovedOrderDTOBuilder postalCode(Integer postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public ApprovedOrderDTOBuilder addressName(String addressName) {
		this.addressName = addressName;
		return this;
	}

	public ApprovedOrderDTOBuilder latitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	public ApprovedOrderDTOBuilder longitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	public ApprovedOrderDTOBuilder districtName(String districtName) {
		this.districtName = districtName;
		return this;
	}

	public ApprovedOrderDTOBuilder cityName(String cityName) {
		this.cityName = cityName;
		return this;
	}

	public ApprovedOrderDTOBuilder postalAbbreviation(String postalAbbreviation) {
		this.postalAbbreviation = postalAbbreviation;
		return this;
	}

	public ApprovedOrderDTOBuilder customerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	public ApprovedOrderDTOBuilder customerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
		return this;
	}

	public ApprovedOrderDTO build() {
		ApprovedOrderDTO approvedOrderDTO = new ApprovedOrderDTO();

		approvedOrderDTO.setBucketId(bucketId);
		approvedOrderDTO.setNumber(number);
		approvedOrderDTO.setStatusId(statusId);
		approvedOrderDTO.setStatus(status);
		approvedOrderDTO.setEstablishmentId(establishmentId);
		approvedOrderDTO.setCorporateName(corporateName);
		approvedOrderDTO.setCnpj(cnpj);
		approvedOrderDTO.setLockerGroupName(lockerGroupName);
		approvedOrderDTO.setLockerId(lockerId);
		approvedOrderDTO.setLockerName(lockerName);
		approvedOrderDTO.setAddressTypeName(addressTypeName);
		approvedOrderDTO.setPostalCode(postalCode);
		approvedOrderDTO.setAddressName(addressName);
		approvedOrderDTO.setLatitude(latitude);
		approvedOrderDTO.setLongitude(longitude);
		approvedOrderDTO.setDistrictName(districtName);
		approvedOrderDTO.setCityName(cityName);
		approvedOrderDTO.setPostalAbbreviation(postalAbbreviation);
		approvedOrderDTO.setCustomerName(customerName);
		approvedOrderDTO.setCustomerEmail(customerEmail);

		return approvedOrderDTO;
	}

}
