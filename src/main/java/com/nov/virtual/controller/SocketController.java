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
@Api(value = "websocket远程通信",tags = {"进行数据的实时传输"})
public class SocketController {

        @GetMapping("/websocket")
        @ApiOperation(value = "websocket远程通信",notes = "此接口进行远程通信，数据的实时传输")
        public ModelAndView socket() {
            ModelAndView mav=new ModelAndView("/websocket");
            return mav;
        }
}
