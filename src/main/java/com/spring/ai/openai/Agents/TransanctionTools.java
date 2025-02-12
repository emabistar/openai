package com.spring.ai.openai.Agents;

import com.spring.ai.openai.entities.Transaction;
import com.spring.ai.openai.entities.TransactionStatus;
import com.spring.ai.openai.repository.TransactionRepository;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TransanctionTools {
    private TransactionRepository transactionRepository;
    public  TransanctionTools(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    @Tool("Get all  transactions")
    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }
    @Tool("Get all  transactions By accountId")
    public List<Transaction> getAllTransactionsByAccountId(long accountId){
        return transactionRepository.findByAccountId(accountId);
    }
    @Tool
    public  Transaction updateTransactionStatus(Long transactionId, TransactionStatus transactionStatus){
         Transaction transaction = transactionRepository.findById(transactionId).get();
         transaction.setStatus(transactionStatus);
         return transactionRepository.save(transaction);
    }
}
