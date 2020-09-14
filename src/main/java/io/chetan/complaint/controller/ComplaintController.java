package io.chetan.complaint.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.chetan.complaint.model.Complaint;
import io.chetan.complaint.service.ComplaintService;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintController 
{

	@Autowired
	private ComplaintService complaintService;
	
	private static final Logger LOGGER = Logger.getLogger(ComplaintController.class.getName());
	
	@GetMapping(value = "/findAll/{pgId}")
	public List<Complaint> loadAllComplaintsOfAPg(@PathVariable long pgId)
	{
		LOGGER.info("\n\n ComplaintController- loadAllComplaintsOfAPg - pgid = \n "+pgId);
		
		return complaintService.loadAllComplaintsOfAPg(pgId);
	}
}
