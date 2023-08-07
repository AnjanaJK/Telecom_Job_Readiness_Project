package com.telecom.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.DTO.ChangePasswordRequestDTO;
import com.telecom.DTO.CreateCustRequestDTO;
import com.telecom.DTO.CreateEngineerRequestDTO;
import com.telecom.DTO.CreateManagerRequestDTO;
import com.telecom.DTO.LoginResponse;
import com.telecom.DTO.TicketCommentDTO;
import com.telecom.DTO.TicketCreateDTO;
import com.telecom.DTO.fetchCustDTO;
import com.telecom.DTO.fetchEngineerDTO;
import com.telecom.DTO.fetchManagerDTO;
import com.telecom.DTO.fetchTicketDTO;
import com.telecom.Entity.Complaint;
import com.telecom.Entity.Customer;
import com.telecom.Entity.Engineer;
import com.telecom.Entity.Manager;
import com.telecom.Entity.TicketComment;
import com.telecom.Entity.User;
import com.telecom.Repository.ICommentRepo;
import com.telecom.Repository.IComplaintRepo;
import com.telecom.Repository.ICustRepo;
import com.telecom.Repository.IEngineerRepo;
import com.telecom.Repository.IManagerRepo;
import com.telecom.Repository.IUserRepo;
import com.telecom.Service.ComplaintService;
import com.telecom.Service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IEngineerRepo engineerRepo;
	
	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private ICustRepo custRepo;
	
	@Autowired
	private IComplaintRepo complaintRepo;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private IManagerRepo managerRepo;

	@Autowired
	private ICommentRepo commentRepo;

	
	// LOGIN
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginAdmin(@RequestBody User userData) {
        System.out.println(userData);

        // check if user is available in the db
        User user = userService.findUser(userData.getUserUsername(), userData.getUserPassword());
        
        
//        System.out.println(cust);
//        System.out.println(user);
        if (user != null && user.getUserPassword().equals(userData.getUserPassword())) {
        	LoginResponse response = new LoginResponse();
        	response.setUser(user);
        	
//        	if("Manager".equals(user.getUserRole())) {
//            	Manager manager = managerRepo.findByManagerName(userData.getUserUsername());
//            	System.out.println(manager.getManagerId());
//            	response.setManager(manager);
//            }

        	if (user.getUserRole().equals("Manager")) {
                Manager manager = managerRepo.findByUserMngr(user);
//                response.setManagerId(manager.getManagerId()); // Set the Manager ID in the response
                response.setManager(manager);
            }
        	if (user.getUserRole().equals("Engineer")) {
                Engineer engineer = engineerRepo.findByUserEng(user);
//                response.setManagerId(manager.getManagerId()); // Set the Manager ID in the response
                response.setEngineer(engineer);
            }
        	if(user.getUserRole().equals("Customer")) {
        		Customer cust = custRepo.findByCustomerUsername(userData.getUserUsername());
        		response.setCustomer(cust);
            }
        	
        	
            
        	return ResponseEntity.ok(response);
        } else {
        	System.out.println(user);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
//        return ResponseEntity.ok().build();
    }
	
//	================================================================================
	
	// ...........................................................
	// ........................ ADMIN ............................
	// ...........................................................
	
	// View All Customers
	@GetMapping("/getAllCust")
	public ResponseEntity<List<Object[]>> viewAllCust(){
		List<Object[]> allCust = userService.getAllCustData();
		return new ResponseEntity<>(allCust, HttpStatus.OK);		
	}
	
	// View All Engineers
	@GetMapping("/getAllEng")
	public ResponseEntity<List<Object[]>> viewAllEng(){
		List<Object[]> allEng = userService.getAllEngData();
		return new ResponseEntity<>(allEng, HttpStatus.OK);		
	}
	
	// View All Engineers
	@GetMapping("/getAllMngr")
	public ResponseEntity<List<Object[]>> viewAllMngr(){
		List<Object[]> allMngr = userService.getAllMngrData();
		return new ResponseEntity<>(allMngr, HttpStatus.OK);		
	}
	
	// +++++
	@PostMapping("/addNewCust")
	public ResponseEntity<?> createUser(@RequestBody CreateCustRequestDTO createCustDTO){
		
//		System.out.println(createCustDTO.getCustPinCode());
		User user = new User();
		user.setUserUsername(createCustDTO.getUserUsername());
		user.setUserPassword(createCustDTO.getUserPassword());
		user.setUserRole("Customer");
		
		Customer cust = new Customer();
		cust.setCustEmail(createCustDTO.getCustEmail());
		cust.setCustomerName(createCustDTO.getCustName());
		cust.setCustomerUsername(createCustDTO.getUserUsername());
		cust.setCustPinCode(createCustDTO.getCustPinCode());
		cust.setUserCust(user);
		
		System.out.println("User: " + user + " | Cust: " + cust);
		
		userRepo.save(user);
		custRepo.save(cust);
        
        return ResponseEntity.ok().build();
	}
	
	@GetMapping("/editCustFetchDetails/{customerId}/{userId}")
	public ResponseEntity<fetchCustDTO> createUser(@PathVariable int customerId, @PathVariable int userId){
	
	 	Customer customer = custRepo.findByCustomerId(customerId);
	 	User user = userRepo.findByUserId(userId);
	 	System.out.println(user);

	 	fetchCustDTO customerDTO = new fetchCustDTO();
	 	customerDTO.setCustId(customer.getCustomerId());
	 	customerDTO.setCustName(customer.getCustomerName());
	 	customerDTO.setCustEmail(customer.getCustEmail());
	 	customerDTO.setCustPinCode(customer.getCustPinCode());
	 	customerDTO.setUserId(user.getUserId());
	 	customerDTO.setUserUsername(user.getUserUsername());
	 	customerDTO.setUserPassword(user.getUserPassword());
	 	
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);		
	}
	
	@PutMapping("/updateCustRecord/{customerId}/{userId}")
	public ResponseEntity<?> updateCustRecord(@RequestBody CreateCustRequestDTO createCustDTO, @PathVariable int customerId, @PathVariable int userId){
		
		Customer customer = custRepo.findByCustomerId(customerId);
	 	User user = userRepo.findByUserId(userId);
//		System.out.println(customerId + userId +  createCustDTO.getCustEmail());
//		User user = new User();
		user.setUserUsername(createCustDTO.getUserUsername());
//		user.setUserPassword(createCustDTO.getUserPassword());
//		user.setUserRole("Customer");
//		
//		Customer cust = new Customer();
		customer.setCustEmail(createCustDTO.getCustEmail());
		customer.setCustomerName(createCustDTO.getCustName());
		customer.setCustomerUsername(createCustDTO.getUserUsername());
		customer.setCustPinCode(createCustDTO.getCustPinCode());
		customer.setUserCust(user);
//		
		System.out.println("User: " + user + "\nCust: " + customer);
//		
		userRepo.save(user);
		custRepo.save(customer);
        
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/deleteCustRecord/{customerId}/{userId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId, @PathVariable int userId){
        custRepo.deleteById(customerId);
        userRepo.deleteById(userId);
        return ResponseEntity.ok().build();
    }
	

	
	// +++++
	@PostMapping("/addNewManager")
	public ResponseEntity<?> createManagerr(@RequestBody CreateManagerRequestDTO createManagerDTO){
		User user = new User();
		user.setUserUsername(createManagerDTO.getUserUsername());
		user.setUserPassword(createManagerDTO.getUserPassword());
		user.setUserRole("Manager");
		
		Manager manager = new Manager();
		manager.setManagerName(createManagerDTO.getManagerName());
//		manager.setManagerFullName(createManagerDTO.getManagerFullName());
		manager.setPinCode(createManagerDTO.getManagerPinCode());
		manager.setUserMngr(user);
		
		userRepo.save(user);
		managerRepo.save(manager);
        
        return ResponseEntity.ok().build();
	}
	
	@GetMapping("/editManagerFetchDetails/{managerId}/{userId}")
	public ResponseEntity<fetchManagerDTO> fetchManager(@PathVariable int managerId, @PathVariable int userId){
		
	 	Manager manager = managerRepo.findByManagerId(managerId);
	 	User user = userRepo.findByUserId(userId);

	 	fetchManagerDTO managerDTO = new fetchManagerDTO();
	 	managerDTO.setManagerId(manager.getManagerId());
	 	managerDTO.setManagerName(manager.getManagerName());
	 	managerDTO.setManagerPinCode(manager.getPinCode());
	 	managerDTO.setUserId(user.getUserId());
	 	managerDTO.setUserUsername(user.getUserUsername());
	 	managerDTO.setUserPassword(user.getUserPassword());
	 	
		return new ResponseEntity<>(managerDTO, HttpStatus.OK);	
	}
	
	@PutMapping("/updateManagerRecord/{managerId}/{userId}")
	public ResponseEntity<?> updateManagerRecord(@RequestBody CreateManagerRequestDTO createManagerDTO, @PathVariable int managerId, @PathVariable int userId){
		
		Manager manager = managerRepo.findByManagerId(managerId);
	 	User user = userRepo.findByUserId(userId);
	 	
		user.setUserUsername(createManagerDTO.getUserUsername());
		manager.setManagerName(createManagerDTO.getManagerName());
		manager.setPinCode(createManagerDTO.getManagerPinCode());
		manager.setUserMngr(user);
		
		userRepo.save(user);
		managerRepo.save(manager);
        
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/deleteManagerRecord/{managerId}/{userId}")
    public ResponseEntity<?> deleteManager(@PathVariable int managerId, @PathVariable int userId){
        managerRepo.deleteById(managerId);
        userRepo.deleteById(userId);
        return ResponseEntity.ok().build();
    }
	
	// +++++
	@GetMapping("/getManagers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerRepo.findAll();
        return ResponseEntity.ok(managers);
    }
	
	@PostMapping("/addNewEngineer")
	public ResponseEntity<?> createEngineer(@RequestBody CreateEngineerRequestDTO createEngineerDTO){
		User user = new User();
		user.setUserUsername(createEngineerDTO.getUserUsername());
		user.setUserPassword(createEngineerDTO.getUserPassword());
		user.setUserRole("Engineer");
		
		Engineer engineer = new Engineer();
		engineer.setEngineerName(createEngineerDTO.getEngineerName());
		
		// Fetch the manager based on selectedManager ID and set it for the engineer
        Manager manager = managerRepo.findByManagerId(createEngineerDTO.getSelectedManager());
        engineer.setManagerId(manager);
		
		engineer.setUserEng(user);
		
		userRepo.save(user);
		engineerRepo.save(engineer);
        
        return ResponseEntity.ok().build();
	}
	
	@GetMapping("/editEngineerFetchDetails/{engineerId}/{userId}")
	public ResponseEntity<fetchEngineerDTO> fetchEngineer(@PathVariable int engineerId, @PathVariable int userId){
		
	 	Engineer engineer = engineerRepo.findByEngineerId(engineerId);
	 	User user = userRepo.findByUserId(userId);

	 	fetchEngineerDTO engineerDTO = new fetchEngineerDTO();
	 	engineerDTO.setEngineerId(engineer.getEngineerId());
	 	engineerDTO.setEngineerName(engineer.getEngineerName());
	 	
//	 	engineerDTO.setSelectedEngineer(engineer.getUserEng());
	 	
	 	engineerDTO.setUserId(user.getUserId());
	 	engineerDTO.setUserUsername(user.getUserUsername());
	 	engineerDTO.setUserPassword(user.getUserPassword());
	 	
	 	engineerDTO.setSelectedManager(engineer.getManagerId().getManagerId());
        engineerDTO.setManagerName(engineer.getManagerId().getManagerName());
        engineerDTO.setPinCode(engineer.getManagerId().getPinCode());
	 	
		return new ResponseEntity<>(engineerDTO, HttpStatus.OK);	
	}
	
	@PutMapping("/updateEngineerRecord/{engineerId}/{userId}")
	public ResponseEntity<?> updateEngineerRecord(@RequestBody CreateEngineerRequestDTO createEngineerDTO, @PathVariable int engineerId, @PathVariable int userId){
		
		Engineer engineer = engineerRepo.findByEngineerId(engineerId);
	 	User user = userRepo.findByUserId(userId);
	 	
		user.setUserUsername(createEngineerDTO.getUserUsername());
		
		engineer.setEngineerName(createEngineerDTO.getEngineerName());
		
        Manager manager = managerRepo.findByManagerId(createEngineerDTO.getSelectedManager());
        engineer.setManagerId(manager);
		
		engineer.setUserEng(user);
		
		userRepo.save(user);
		engineerRepo.save(engineer);
        
        return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/deleteEngineerRecord/{engineerId}/{userId}")
    public ResponseEntity<?> deleteEngineer(@PathVariable int engineerId, @PathVariable int userId){
        engineerRepo.deleteById(engineerId);
        userRepo.deleteById(userId);
        return ResponseEntity.ok().build();
    }
	
	// ..............................................................
	// ........................ CUSTOMER ............................
	// ..............................................................
	
	// ADD NEW TICKET
	@PostMapping("/createTicket/{customerId}")
	public ResponseEntity<?> createTicket(@RequestBody TicketCreateDTO ticketCreateDTO, @PathVariable int customerId){
		
//		System.out.println(ticketCreateDTO.getCustPinCode());
		Complaint complaint = new Complaint();
		complaint.setCustName(ticketCreateDTO.getCustName());
		complaint.setAddress(ticketCreateDTO.getCustAddress());
		complaint.setPinCode(ticketCreateDTO.getCustPinCode());
		complaint.setProblemDesc(ticketCreateDTO.getProblemDesc());
		complaint.setProblemType(ticketCreateDTO.getSelectedProblem());
		complaint.setTelMobNo(ticketCreateDTO.getCustPhoneNo());
		complaint.setTicketDate(LocalDate.now());
		complaint.setStatus("RAISED");
		
		Customer customer = custRepo.findByCustomerId(customerId);
		complaint.setCustComplaint(customer);
		
//		System.out.println(complaint);
		
//		complaint.setTicketId(101);
		
		Complaint savedComplaint = complaintRepo.save(complaint);
		int ticketId  = savedComplaint.getTicketId();
		String responseMessage = "Ticket generated successfully! #" + ticketId;
//		System.out.println(responseMessage);
		Map<String, Object> responseBody = new HashMap<>();
	    responseBody.put("message", responseMessage);
        return ResponseEntity.ok(responseBody);
	}
	
	
	@GetMapping("/showRaised/{customerId}")
	public ResponseEntity<List<Object[]>> allRaisedTickets(@PathVariable int customerId){
		List<Object[]> complaints = complaintRepo.findByCustComplaintCustomerId(customerId);
		return ResponseEntity.ok(complaints);
	}
	
	@GetMapping("/showSolved/{customerId}")
	public ResponseEntity<List<Object[]>> allSolvedTickets(@PathVariable int customerId){
		List<Object[]> complaints = complaintRepo.solvedTickets(customerId);
		return ResponseEntity.ok(complaints);
	}
	
	@GetMapping("/showProfileInfo/{customerId}")
	public ResponseEntity<List<Object[]>> getProfileInfo(@PathVariable int customerId){
		List<Object[]> info = custRepo.findInfo(customerId);
		return ResponseEntity.ok(info);
	}
	
	
	@PutMapping("/changePassword/{userId}")
	public ResponseEntity<?> changePass(@RequestBody ChangePasswordRequestDTO passwordDTO, @PathVariable int userId){
		
//		System.out.println(userId);
		User user = userRepo.findByUserId(userId);
		
		String oldPassword = passwordDTO.getOldPassword();
		String newPassword = passwordDTO.getNewPassword();
		
		System.out.println(oldPassword + " | " + newPassword);
		
		if(oldPassword.equals(user.getUserPassword())) {
			 if (!oldPassword.equals(newPassword)) {
				user.setUserPassword(newPassword);
				System.out.println("new password set");
				userRepo.save(user);
			 }
		
			System.out.println("DIFF");
			return ResponseEntity.ok().build();			
		}
		 else {
			 System.out.println("error");
			 return ResponseEntity.badRequest().body("Error");
	    }

//		return ResponseEntity.ok().build();	
	}
	
	
	// .............................................................
	// ........................ MANAGER ............................
	// .............................................................
	
	@GetMapping("/showEngineers/{managerId}")
	public ResponseEntity<List<Object[]>> getMyEngineer(@PathVariable int managerId){
		List<Object[]> engineers = engineerRepo.findByManagerIdManagerId(managerId);
		return ResponseEntity.ok(engineers);
	}
	
	@GetMapping("/viewAllTickets")
	public ResponseEntity<List<Object[]>> getAllTickets(){
		List<Object[]> tickets = managerRepo.findAllTickets();
		return ResponseEntity.ok(tickets);
	}
	
	@PutMapping("/assign/{ticketId}")
	public ResponseEntity<String> assignTicket(@PathVariable int ticketId, @RequestBody int engineerId){
		
		
		System.out.println("Ticket Id: " + ticketId);
		System.out.println("Engineer Id: " + engineerId);
		
		try {
            complaintService.updateComplaintAssigned(ticketId, engineerId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

//		return ResponseEntity.ok().build();	
	}
	
	
	@GetMapping("/viewComplaints/{ticketId}")
	public ResponseEntity<fetchTicketDTO> viewComplaintDetails(@PathVariable int ticketId){
		
//		Customer customer = custRepo.findByCustomerId(customerId);
//	 	User user = userRepo.findByUserId(userId);
		System.out.println("ticketId: " + ticketId);
		Complaint ticket = complaintService.findByTicketId(ticketId);
//		System.out.println(ticket.getTicketId());
		
		fetchTicketDTO ticketDTO = new fetchTicketDTO();
		ticketDTO.setCustName(ticket.getCustName());
		ticketDTO.setCustAddress(ticket.getAddress());
		ticketDTO.setCustPinCode(ticket.getPinCode());
		ticketDTO.setProblemDesc(ticket.getProblemDesc());
		ticketDTO.setProblemType(ticket.getProblemType());
		ticketDTO.setCustPhoneNo(ticket.getTelMobNo());
		ticketDTO.setTicketDate(ticket.getTicketDate());
		ticketDTO.setStatus(ticket.getStatus());
		
		if(ticket.getAssignedEngineer() != null) {
			int engineerId = ticket.getAssignedEngineer().getEngineerId();
			Engineer assignedEngineer = engineerRepo.findByEngineerId(engineerId);
			ticketDTO.setAssignedEngineer(assignedEngineer.getEngineerName());
		}
		
        
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
	}

	
	// ..............................................................
	// ........................ ENGINEER ............................
	// ..............................................................
	
	@GetMapping("/viewAllTicketsEngineer/{engineerId}")
	public ResponseEntity<List<Object[]>> getAllTicketsEngineer(@PathVariable int engineerId){
		List<Object[]> tickets = engineerRepo.findAllTicketsEngineer(engineerId);
		return ResponseEntity.ok(tickets);
	}
	
	@PostMapping("/addComment")
	public ResponseEntity<TicketCommentDTO> createComment(@RequestBody TicketCommentDTO commentDTO){
		
		// Fetch the Complaint entity using the ticketId from the DTO
        Complaint complaint = complaintRepo.findByTicketId(commentDTO.getTicketId());
        if (complaint ==null) {
        	System.out.println("NULL");
        }
        else {
        	System.out.println("Woohoo\n\n");
        }
        
		System.out.println(commentDTO.getCommentBy());
		System.out.println(commentDTO.getCommentText());
		System.out.println(commentDTO.getTicketId());
		System.out.println(commentDTO.getCommentDate());
		
		TicketComment comment = new TicketComment();
		comment.setCommentBy(commentDTO.getCommentBy());
		comment.setCommentDate(LocalDateTime.now());
		comment.setCommentText(commentDTO.getCommentText());
		comment.setTicket(complaint);
		
		commentRepo.save(comment);
		
		 return ResponseEntity.ok(commentDTO);
	}
	
	@GetMapping("/getCommentComments/{ticketId}")
	public ResponseEntity<List<TicketComment>> getAllComments(@PathVariable int ticketId){
//		List<Object[]> tickets = engineerRepo.findAllTicketsEngineer(engineerId);
		System.out.println("BLAH: " + ticketId);
		List<TicketComment> comments = commentRepo.findByTicketTicketId(ticketId);
		return ResponseEntity.ok(comments);
	}
	
	
	@PutMapping("/updateTicketStatus/{ticketId}/{status}")
	public ResponseEntity<String> updateTicketStatus(@PathVariable int ticketId, @PathVariable String status) {
		System.out.println(ticketId + " | " + status);
		// Update the ticket status in the database based on the ticketId and status
		 Complaint ticket = complaintRepo.findByTicketId(ticketId);
	        if (ticket == null) {
	            return ResponseEntity.notFound().build();
	        }

	        ticket.setStatus(status);
	        complaintRepo.save(ticket);
	        
		return ResponseEntity.ok("Ticket status updated successfully");
	}
	
	
}
