package com.db.ollama.coontrller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @projectName:SpringAI
 * @see:com.db.ollama.coontrller
 * @author:db
 * @createTime:2024/7/11 10:21
 * @version:1.0
 */
@RestController
public class OllamaController {
    @Resource
    private OllamaChatModel ollamaChatClient;

    @RequestMapping(value = "/ai/ollama1")
    private Object chat(@RequestParam(value = "msg" ) String msg){
        String call = ollamaChatClient.call(msg);
        return call;
    }
    @RequestMapping(value = "/ai/multimodel1")
    private Object multimodel1(@RequestParam(value = "msg" ) String msg) {
            String call = ollamaChatClient.call(msg);
            return call;
    }

}
