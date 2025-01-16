package com.Bank.ApiGateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {

	private String jwtToken;
	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getJwtToken() {
		return jwtToken;
	}

	public static class Builder {
		private String jwtToken;

		public Builder setJwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
			return this;
		}

		public JwtResponse build() {
			return new JwtResponse(jwtToken);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
