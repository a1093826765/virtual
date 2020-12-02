package com.nov.virtual.controller;

import com.nov.virtual.websocket.WebSocketServer;
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

        @RequestMapping("/index")
        public String index() {
            return "index";
        }

        @GetMapping("/webSocket")
        public ModelAndView socket() {
            ModelAndView mav=new ModelAndView("/webSocket");
            return mav;
        }
}
