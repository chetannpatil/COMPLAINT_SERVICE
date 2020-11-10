package io.chetan.complaint.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	//CREATE
	@GetMapping(value = "/read")
	public Complaint read()
	{
		LOGGER.info("\n\n ComplaintController- read = \n ");
		
		//return complaintService.create(complaint);
		
		Complaint complaint = new Complaint();
		
		complaint.setComplaintId(12L);
		
		complaint.setDescription("Weather is hot AC is not working");
		
		complaint.setInMate(1L);
		
		complaint.setMyPg(1L);
		
		return complaint;
	}
	
	
	
	//CREATE
	@PostMapping(value = "/create")
	public Complaint create(@RequestBody Complaint complaint)
	{
		LOGGER.info("\n\n ComplaintController- create - complaint = \n "+complaint);
		
		return complaintService.create(complaint);
	}
	
	
	//READ
	@GetMapping(value = "find/{complaintId}")
	public Complaint find(@PathVariable long complaintId)
	{
		LOGGER.info("\n\n ComplaintController- find - complaintId = \n "+complaintId);
		
		return complaintService.find(complaintId);
	}
	@GetMapping(value = "/findAll/{pgId}")
	public List<Complaint> loadAllComplaintsOfAPg(@PathVariable long pgId)
	{
		LOGGER.info("\n\n ComplaintController- loadAllComplaintsOfAPg - pgid = \n "+pgId);
		
		return complaintService.loadAllComplaintsOfAPg(pgId);
	}
	
	@GetMapping(value = "/findAll/inMateId/{inMateId}")
	public List<Complaint> loadAllComplaintsOfAnInMate(@PathVariable long inMateId)
	{
		LOGGER.info("\n\n ComplaintController- loadAllComplaintsOfAnInMate - pgid = \n "+inMateId);
		return complaintService.loadAllComplaintsOfAnInMate(inMateId);
	}
	
	
	//UPDATE
	@PutMapping(value = "/update")
	public void update(@RequestBody Complaint complaint)
	{
		LOGGER.info("\n\n ComplaintController- update - complaint = \n "+complaint);
		
		complaintService.update(complaint);
	}
	
	//DELETE 
	@DeleteMapping(value = "/delete/{complaintId}")
	public void delete(@PathVariable long complaintId)
	{
		LOGGER.info("\n\n ComplaintController- delete - complaintId = \n "+complaintId);
		
		complaintService.delete(complaintId);
	}
	/*
	 * did not work
	 * 
	 * @DeleteMapping(value = "/delete") public void delete(@PathVariable long
	 * complaintId) {
	 * LOGGER.info("\n\n ComplaintController- delete - complaintId = \n "
	 * +complaintId);
	 * 
	 * complaintService.delete(complaintId); }
	 */
}
