package io.chetan.complaint.service;

import java.util.List;
import java.util.Optional;
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

	public List<Complaint> loadAllComplaintsOfAnInMate(long inMateId)
	{
		LOGGER.info("\n\n ComplaintService- loadAllComplaintsOfAnInMate - inMateId = \n "+inMateId);
		
		return complaintDao.findByInMate(inMateId);
	}

	public Complaint create(Complaint complaint)
	{
		LOGGER.info("\n\n ComplaintService- create - complaint = \n "+complaint);
		
		return complaintDao.save(complaint);
	}

	public void update(Complaint complaint)
	{
		LOGGER.info("\n\n ComplaintService- update - complaint = \n "+complaint);
		
		Complaint updatedComplaint = complaintDao.save(complaint);
		
		LOGGER.info("\n\n ComplaintService- update - updatedComplaint = \n\n "+updatedComplaint);
	}

	public Complaint find(long complaintId)
	{
		LOGGER.info("\n\n ComplaintService- find - complaintid = \n "+complaintId);
		
		Optional<Complaint> optional = complaintDao.findById(complaintId);
		
		return optional.get();
	}

	public void delete(long complaintId)
	{
		LOGGER.info("\n\n ComplaintService- delete - complaintid = \n "+complaintId);
		
		complaintDao.deleteById(complaintId);
		
	}
}
