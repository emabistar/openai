package com.spring.ai.openai.web;

import com.spring.ai.openai.Agents.TransactionaiAgent;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class ChatController {

 private ChatLanguageModel chatLanguageModel;
    public ChatController(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;


    }
    @GetMapping("/chat")
    public String chat(@RequestParam (defaultValue ="hello")String question) {
        return chatLanguageModel.chat(question);
    }


}
