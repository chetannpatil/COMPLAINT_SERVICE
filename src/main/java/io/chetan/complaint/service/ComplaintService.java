package io.chetan.complaint.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.complaint.controller.ComplaintController;
import io.chetan.complaint.dao.ComplaintDao;
import io.chetan.complaint.model.Complaint;

@Service
public class ComplaintService 
{

	@Autowired
	private ComplaintDao complaintDao ;

	private static final Logger LOGGER = Logger.getLogger(ComplaintService.class.getName());
	
	public List<Complaint> loadAllComplaintsOfAPg(long pgId) 
	{
		LOGGER.info("\n\n ComplaintService- loadAllComplaintsOfAPg - pgid = \n "+pgId);
		
		return complaintDao.findByMyPg(pgId) ;
	}
}
