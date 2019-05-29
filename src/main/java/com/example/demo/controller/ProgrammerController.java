package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Programmer;
import com.example.demo.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProgrammerController {
	
	@Autowired
	ProgrammerService programmerService;
	
	// *******************String Demo*******************//

		@RequestMapping(method = RequestMethod.POST, value = "/programmer-string")
		public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
			programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
					mapper.writeValueAsString(programmer));

		}

		@RequestMapping("/programmer-string/{id}")
		public String readString(@PathVariable String id) {
			return programmerService.getProgrammerAsString(id);

		}

}
