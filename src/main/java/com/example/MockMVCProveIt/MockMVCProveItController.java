package com.example.MockMVCProveIt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockMVCProveItController {

	@RequestMapping(value = "/ProveIt", method = RequestMethod.GET)
	public ResponseEntity<MockMVCProveItEntity> entity() {
		return new ResponseEntity<MockMVCProveItEntity>(new MockMVCProveItEntity(55), HttpStatus.OK);
	}
}
