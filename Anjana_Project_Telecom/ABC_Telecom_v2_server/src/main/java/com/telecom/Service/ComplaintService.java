package com.telecom.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.Entity.Complaint;
import com.telecom.Entity.Engineer;
import com.telecom.Repository.IComplaintRepo;

@Service
public class ComplaintService {

	@Autowired
	private IComplaintRepo complaintRepo;
	
	 public void updateComplaintAssigned(int ticketId, int engineerId) {
	        // Fetch the Complaint by ticketId
	        Optional<Complaint> optionalComplaint = complaintRepo.findById(ticketId);
	        if (optionalComplaint.isPresent()) {
	        	
	            Complaint complaint = optionalComplaint.get();

	            // Fetch the Engineer by engineerId
	            Engineer engineer = new Engineer();
	            engineer.setEngineerId(engineerId);
	            complaint.setAssignedEngineer(engineer);
	            complaint.setStatus("WIP");
	            System.out.println(engineer);
	            System.out.println(complaint);
	            
//
//	            // Save the updated Complaint
	            complaintRepo.save(complaint);
	        } else {
	            throw new RuntimeException("Complaint not found with ticketId: " + ticketId);
	        }
	    }

	public Complaint findByTicketId(int ticketId) {
		return complaintRepo.findByTicketId(ticketId);
	}
}
