package com.db.text.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:SpringAI
 * @see:com.db.text.controller
 * @author:db
 * @createTime:2024/7/10 11:01
 * @version:1.0
 */

@RestController
public class TextController {
    @Resource
    private OpenAiAudioTranscriptionModel openAiAudioTranscriptionClient;

    @Resource
    private OpenAiAudioSpeechModel openAiAudioSpeechClient;
    @RequestMapping(value = "/ai/text1")
    private Object text1() {
        ClassPathResource resource = new ClassPathResource("jkf.mp3");
        String call = openAiAudioTranscriptionClient.call(resource);
        System.out.println(call);
        return call;
    }
    @RequestMapping(value = "/ai/text2")
    private Object text2(@RequestParam(value = "msg") String msg) {
        byte[] call = openAiAudioSpeechClient.call(msg);
        System.out.println(call);
        return "ok";
    }
}
