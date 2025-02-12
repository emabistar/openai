package com.spring.ai.openai.Agents;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import dev.langchain4j.service.Result;



@AiService
@Component
public interface TransactionaiAgent {
    @SystemMessage (""" 
        You are a helpful assistant, you role is to answer the 
        user's question using the provide  context.
         """)
    String chat(String question);

}
