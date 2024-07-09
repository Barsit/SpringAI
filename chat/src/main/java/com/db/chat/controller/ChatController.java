package com.db.chat.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:SpringAI
 * @see:com.db.chat.controller
 * @author:db
 * @createTime:2024/7/9 17:33
 * @version:1.0
 */
@RestController
public class ChatController {
/** description 
 * param
 * return 
 * author db
 * createTime 2024/7/9 17:34
*/
    @Resource
    private OpenAiChatModel openAiChatClient;
    @RequestMapping(value = "/ai/chat")
    public String chat(@RequestParam(value = "msg") String msg){
        String call = openAiChatClient.call(msg);
        return call;
    }

    @RequestMapping(value = "/ai/chat2")
    public Object chat2(@RequestParam(value = "msg") String msg){
        ChatResponse chatResponse = openAiChatClient.call(new Prompt(msg));
        return chatResponse.getResult().getOutput().getContent();

    }
    @RequestMapping(value = "/ai/chat3")
    public Object chat3(@RequestParam(value = "msg") String msg){
        ChatResponse chatResponse = openAiChatClient.call(new Prompt(msg, OpenAiChatOptions.builder()
                .withModel("gpt-3-turbo")
                .withTemperature(0.7F)
                .build()));
        return chatResponse.getResult().getOutput().getContent();

    }

}
