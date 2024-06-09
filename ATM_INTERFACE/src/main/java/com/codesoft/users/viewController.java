package com.codesoft.users;

import javax.security.auth.login.AccountNotFoundException;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codesoft.Account.AccountDetails;
import com.codesoft.Account.AccountReposatory;
import com.codesoft.exception.AccountNotFoundEception;
import com.codesoft.exception.AmountIsGreaterThanBalanceException;

@Controller
public class viewController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountReposatory repo;
	
	
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	@GetMapping("/withdraw")
	public String register() {
		return "withdraw";
	}
	@GetMapping("/checkbalance")
	public String checkbalance() {
		return "checkbalance";
	}
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@GetMapping("/showbalance")
	public String getBalance(@RequestParam long acoountNumber,Model model) 
	{
		String viewName;
		AccountDetails details=repo.findByAccountNumber(acoountNumber)
					.orElseThrow(()->new AccountNotFoundEception("Not found"));
		Double balance;
		if(details!=null) {
		balance=details.getBalance();
		model.addAttribute("BalanceOfUser", balance);
		viewName="result";
		}else {
			model.addAttribute("erroracc", "Account not Found");
			viewName="error";
		}
			
		return viewName;
	}
	
	@PostMapping("/deposit")
	public String depositAmount(@RequestParam double amount,@RequestParam long accountNumber,Model model) {
		AccountDetails details=repo.findByAccountNumber(accountNumber)
				.orElseThrow(()->new AccountNotFoundEception("Not found"));
		
	Double Updatedbalance=details.getBalance()+amount;
	// save amount into database
	model.addAttribute("updatedbalance", Updatedbalance);
	return "updatedbalance"; 
	}
	
	@PostMapping("/withdraw")
	public String withdrawAmount(@RequestParam double amount,@RequestParam long accountNumber,Model model) {
			AccountDetails details=repo.findByAccountNumber(accountNumber)
					.orElseThrow(()->new AccountNotFoundEception("Not found"));
	
			Double balance=details.getBalance();
		Double	UpdatedBalance;
		if(balance>amount) {
				UpdatedBalance=balance-amount;
				model.addAttribute("balanceAfterWithdrawing", UpdatedBalance);
				//save updated balance in database
		}else {
			throw new AmountIsGreaterThanBalanceException("amount is greater that balance");
		}
		
		return "withdrawbalance";
	}
	
}
