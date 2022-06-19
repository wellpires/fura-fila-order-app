package br.com.furafila.orderapp.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.orderapp.dto.ApprovedOrderDTO;

public class ApprovedOrdersResponse {

	@JsonProperty("orders")
	private List<ApprovedOrderDTO> approvedOrderDTOs;

	public ApprovedOrdersResponse() {
	}

	public ApprovedOrdersResponse(List<ApprovedOrderDTO> approvedOrderDTOs) {
		this.approvedOrderDTOs = approvedOrderDTOs;
	}

	public List<ApprovedOrderDTO> getApprovedOrderDTOs() {
		return approvedOrderDTOs;
	}

	public void setApprovedOrderDTOs(List<ApprovedOrderDTO> approvedOrderDTOs) {
		this.approvedOrderDTOs = approvedOrderDTOs;
	}

}
