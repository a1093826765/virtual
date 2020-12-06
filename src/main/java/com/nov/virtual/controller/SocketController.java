package com.nov.virtual.controller;

import com.nov.virtual.websocket.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author november
 */
@Controller
public class SocketController {

        @GetMapping("/websocket")
        public ModelAndView socket() {
            ModelAndView mav=new ModelAndView("/websocket");
            return mav;
        }
}
