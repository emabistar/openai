package com.spring.ai.openai.web;

import com.spring.ai.openai.Agents.TransactionaiAgent;
import com.spring.ai.openai.entities.Transaction;
import com.spring.ai.openai.repository.TransactionRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TransactionController {
    public TransactionaiAgent agent;
    TransactionRepository transactionRepository;

    public TransactionController(TransactionaiAgent agent, TransactionRepository transactionRepository) {
        this.agent = agent;
        this.transactionRepository = transactionRepository;

    }

    @GetMapping("/transactions")
    public List<Transaction> transactions(){
        return transactionRepository.findAll();
    }

    @GetMapping("/askAgent")
    public String chat(@RequestParam(defaultValue ="hello")String question) {
        return  agent.chat(question);
    }



}
