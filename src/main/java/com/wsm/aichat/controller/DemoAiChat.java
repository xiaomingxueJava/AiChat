package com.wsm.aichat.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsm.aichat.domain.pojo.Demo;
import dev.langchain4j.community.model.dashscope.QwenStreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DemoAiChat {


    @GetMapping("/student")
    public String getStudentInfo(HttpServletRequest request){
        Demo demo = new Demo();
        demo.setName("张三");
        demo.setGender("男");
        demo.setAge(20);
        System.out.println(request.getLocalAddr()+" : "+request.getLocalPort());
        return JSONObject.toJSONString(demo);
    }

    @GetMapping(value = "/chat",produces = "text/html;charset=utf-8")
    public Flux<String> chat(String msg){
        QwenStreamingChatModel qwenModel = QwenStreamingChatModel.builder()
                .apiKey("xlsx")
                .modelName("qwen-max")
                .build();

        return Flux.create(sink->{
            qwenModel.chat(msg, new StreamingChatResponseHandler() {
                @Override
                public void onPartialResponse(String s) {
                    // 按照token输出
                    sink.next(s);

                }

                @Override
                public void onCompleteResponse(ChatResponse chatResponse) {
                    System.out.println("onCompleteResponse: " + chatResponse);
                    sink.complete();
                }

                @Override
                public void onError(Throwable throwable) {

                }
            });
        });
    }
}
