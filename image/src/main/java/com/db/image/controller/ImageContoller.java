package com.db.image.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:SpringAI
 * @see:com.db.image.controller
 * @author:db
 * @createTime:2024/7/10 10:27
 * @version:1.0
 */
@RestController
public class ImageContoller {
    @Resource
    private OpenAiImageModel openAiImageClient;

    @RequestMapping(value = "/ai/image1")
    private Object image1(@RequestParam(value = "msg") String msg){
        ImageResponse imageResponse = openAiImageClient.call(new ImagePrompt(msg));
        System.out.println(imageResponse);
        return imageResponse.getResult().getOutput();
    }

    @RequestMapping(value = "/ai/image2")
    private Object image2(@RequestParam(value = "msg") String msg){
        ImageResponse imageResponse = openAiImageClient.call(new ImagePrompt(msg, OpenAiImageOptions.builder()
                .withQuality("hd")
                .withN(1)
                .withHeight(1024)
                .withWidth(1024).build()));
        System.out.println(imageResponse);
        return imageResponse.getResult().getOutput();
    }


}
