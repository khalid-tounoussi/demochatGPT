package com.dosi.controller;

import com.dosi.controller.dto.ResponseModel;
import com.dosi.dto.Message;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
public class Controller {

    @Autowired
    private ChatgptService chatgptService;

    @PostMapping("/send")
    public ResponseModel send(@RequestBody Message message) {
        try {
            String responseMessage = chatgptService.sendMessage(message.getMessage());
            return ResponseModel.success(responseMessage);
        } catch (Exception e) {
            return new ResponseModel(500, "error", e.getMessage());
        }
    }

}
