package com.hans.srs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.srs.entity.CodeSet;
import com.hans.srs.entity.CodeValue;
import com.hans.srs.exception.ErrorCode;
import com.hans.srs.exception.SRSException;
import com.hans.srs.model.SRSResponse;
import com.hans.srs.model.SRSStatus;
import com.hans.srs.model.codeset.CodeSetRequest;
import com.hans.srs.model.codeset.CodeValueRequest;
import com.hans.srs.repository.CodeSetRepository;
import com.hans.srs.repository.CodeValueRespository;

@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private CodeSetRepository codeSetRepository;
	
	@Autowired
	private CodeValueRespository codeValueRepository;

	@PostMapping("/code-set")
	public ResponseEntity<SRSResponse> saveCodeSet(@RequestBody CodeSetRequest codeSetRequest) {
		CodeSet codeSet = new CodeSet(codeSetRequest.getName(), codeSetRequest.getDescription());
		System.out.println("Going to save code set");
		codeSet = codeSetRepository.save(codeSet);
		SRSResponse srsResponse = new SRSResponse(SRSStatus.SUCCESS, "Code set " + codeSet.getName() + " saved successfully with id " + codeSet.getId());
		return ResponseEntity.ok(srsResponse);
	}
	
	@PostMapping("/code-value")
	public ResponseEntity<SRSResponse> saveCodeValue(@RequestBody CodeValueRequest codeValueRequest) {
		Optional<CodeSet> codeSet = codeSetRepository.findByName(codeValueRequest.getCodeSetName());
		if(!codeSet.isPresent()) {
			throw  new SRSException("Cannot find code set with name " + codeValueRequest.getCodeSetName(), HttpStatus.BAD_REQUEST, ErrorCode.CODE_SET_NOT_FOUND);
		}
		// codeSet.orElseThrow(() -> new SRSException("Cannot find code set with name " + codeValueRequest.getCodeSetName(), HttpStatus.BAD_REQUEST));
		CodeValue codeValue = new CodeValue(codeValueRequest.getName(), codeValueRequest.getValue(), codeValueRequest.getDescription(), codeSet.get());
		codeValue = codeValueRepository.save(codeValue);
		SRSResponse srsResponse = new SRSResponse(SRSStatus.SUCCESS, "Code value " + codeValue.getName() + " in code set " + codeSet.get().getName() + " saved successfully with id " + codeValue.getId());
		return ResponseEntity.ok(srsResponse);
	}
	
}
