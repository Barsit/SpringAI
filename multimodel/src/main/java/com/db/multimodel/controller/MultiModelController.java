package com.db.multimodel.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @projectName:SpringAI
 * @see:controller
 * @author:db
 * @createTime:2024/7/10 16:57
 * @version:1.0
 */
@RestController
public class MultiModelController {
    @Resource
    private ChatModel chatModel;
    
    @RequestMapping(value = "/ai/multimodel1")
    private Object multimodel1(String msg,String imageUrl) {
        var userMessage = new UserMessage(msg,
                List.of(new Media(MimeTypeUtils.IMAGE_PNG,
                        imageUrl)));
        ChatResponse response = chatModel.call(new Prompt(List.of(userMessage),
                OpenAiChatOptions.builder().withModel(OpenAiApi.ChatModel.GPT_4_VISION_PREVIEW.getValue()).build()));
        return response.getResult().getOutput().getContent();
                    }


}
