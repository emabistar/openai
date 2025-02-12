package com.spring.ai.openai.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.listener.ChatModelErrorContext;
import dev.langchain4j.model.chat.listener.ChatModelListener;
import dev.langchain4j.model.chat.listener.ChatModelRequestContext;
import dev.langchain4j.model.chat.listener.ChatModelResponseContext;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LangChainConfig {

    @Bean
    public OpenAiChatModel streamingChatModel() {
        return OpenAiChatModel.builder()
                .apiKey("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") // Replace with your actual API key
                .build();
    }

    @Bean
    ChatModelListener chatModelListener() {
        return new ChatModelListener() {

            private static final Logger log = LoggerFactory.getLogger(ChatModelListener.class);

            @Override
            public void onRequest(ChatModelRequestContext requestContext) {
                log.info("onRequest(): {}", requestContext.request());
            }

            @Override
            public void onResponse(ChatModelResponseContext responseContext) {
                log.info("onResponse(): {}", responseContext.response());
            }

            @Override
            public void onError(ChatModelErrorContext errorContext) {
                log.info("onError(): {}", errorContext.error().getMessage());
            }
        };
    }

}
