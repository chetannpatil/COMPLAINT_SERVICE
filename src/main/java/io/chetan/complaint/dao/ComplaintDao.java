package io.chetan.complaint.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.chetan.complaint.model.Complaint;

public interface ComplaintDao extends CrudRepository<Complaint, Long>
{

	List<Complaint> findByMyPg(long pgId);

}
