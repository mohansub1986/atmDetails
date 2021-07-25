package com.mohansub.atm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohansub.atm.model.JsonRootBean;

/**
 * 
 * @author mohansub This class manages the ATM details of multiple cities
 *
 */
@RestController
public class AtmRestController {

	final static Logger logger = LoggerFactory.getLogger(AtmRestController.class);

	private List<JsonRootBean> dataList = new ArrayList<>();
	public final ObjectMapper mapper = new ObjectMapper();

	/** This method shows all the atm details in cities */
	@GetMapping(value = "/allAtms")
	public String getAtmDetailsInJson() {

		try {
			String response = initialize();
			if(null != response) {
				return response;
			}
			StringBuilder jsonResponseStr = new StringBuilder();
			getDataList().forEach(val -> {
				try {
					jsonResponseStr.append(mapper.writeValueAsString(val));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			});
			
			return jsonResponseStr.toString();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

	}

	/** This method shows the atm details of the selected city */
	@GetMapping(path = "/allAtms/fetchAtmByCity/{city}")
	public String getAtmByCity(@PathVariable("city") String city) {
		
		String response = initialize();
		if(null != response) {
			return response;
		}
		StringBuilder jsonResponseStr = new StringBuilder();
		try {

			List<JsonRootBean> filteredList = getDataList().stream()
					.filter(root -> root.getAddress().getCity().equals(city)).map(root -> root)
					.collect(Collectors.toList());

			logger.debug("Size --> " + filteredList.size());
			filteredList.forEach(val -> {
				try {
					jsonResponseStr.append(mapper.writeValueAsString(val));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
		return jsonResponseStr.toString();
	}

	/* Initialize the ATM list from the third party url */
	public String initialize() {
		try {
			if (getDataList().size() == 0) {
				String url = "https://www.ing.nl/api/locator/atms/";

				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
				String result = response.getBody();
				JSONArray ja = new JSONArray(result.substring(5));

				StreamSupport.stream(ja.spliterator(), false).peek(val -> logger.debug(val.toString())).forEach(val -> {
					try {
						dataList.add(mapper.readValue(val.toString(), JsonRootBean.class));
					} catch (JsonProcessingException e) {
						e.printStackTrace();
						logger.debug(e.getMessage());
					}
				});
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}

	/* Setters Getters */
	public List<JsonRootBean> getDataList() {
		return dataList;
	}

	public void setDataList(List<JsonRootBean> dataList) {
		this.dataList = dataList;
	}

}
