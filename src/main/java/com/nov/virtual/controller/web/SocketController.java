package com.nov.virtual.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
